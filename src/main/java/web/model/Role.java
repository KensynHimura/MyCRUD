package web.model;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    public Role() {
    }
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role(String username, String role) {
        this.username = username;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
