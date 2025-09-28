package bookstore.personalblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class modelUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
   @Enumerated(EnumType.STRING)
   private role role;

   @OneToMany(mappedBy = "user")
    private List<modelBlog> blogs;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {//Возвращает список прав ролей пользователей
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {//возвращает пароль пользователя
        return password;
    }

    @Override
    public String getUsername() {//здесь мы указываем что авторизация будет происходить по email
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {//Время действия аккаунта
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//Аккаунты не блокируются
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//Обязательная смена пароля после какого-то времени
        return true;
    }

    @Override
    public boolean isEnabled() {//Активирован ли аккаунт
        return true;
    }
}
        //Не забудь
        //isAccountNonLocked() → временные блокировки (безопасность, защита от атак).
        //isEnabled() → постоянные или административные отключения (бан, неактивный аккаунт).








