import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.HttpStatus;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.router.ignoreTrailingSlashes = true;
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost(); // Esto sigue funcionando en 6.6.0
                });
            });
        });

        app.get("/", ctx -> ctx.result("Hola mundo desde Javalin 6"));

        app.start(7070);
    }
}
