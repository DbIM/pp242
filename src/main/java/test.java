import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class test {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
        //$2a$10$wWES1YcONJZOVxfuvZzM4.Jx9yrAA1DyEhRVR1ovu4PhG5YeQBkTi
    }
}
