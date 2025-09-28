package bookstore.personalblog.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Blog")
public class modelBlog {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   private String title;
   private String text;
   private String data;

   @ManyToOne
    @JoinColumn(name="user_id")
    private modelUser user;
}

