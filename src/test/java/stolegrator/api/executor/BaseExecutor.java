package stolegrator.api.executor;
import io.restassured.http.ContentType;
import java.util.Random;

public class BaseExecutor implements TestBase {
    public BaseExecutor() {
        requestSpec.baseUri("http://test-api.d6.dev.devcaz.com/");
        requestSpec.contentType(ContentType.JSON);
    }

    public static void authAsGuest() {
        resetAuth();
        requestSpec.auth()
                .preemptive()
                .basic("front_2d6b0a8391742f5d789d7d915755e09e", "");
    }

    public static void setAuthToken(String token) {
        resetAuth();
        requestSpec.header("Authorization", "Bearer " + token);
    }

    public static String generateRandomNum(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; ++i) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    public static void resetAuth() {
        requestSpec.removeCookies();
        requestSpec.removeHeader("authorization");
    }

}
