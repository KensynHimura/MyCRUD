package web.model;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account implements UserDetails {

//    @Id
//    @Column(name = "acc_id")
//    private int id_account;

    @Id
    @Column(name = "acc_username")
    private String username;

    @Column(name = "acc_password")
    private String password;

    @Column
    private byte access;


    @OneToMany
    private Set<Role> role;

//    @JoinColumn(name = "roles")
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "merge", joinColumns = @JoinColumn(name="role_id"),
//            inverseJoinColumns = @JoinColumn(name="acc_username"))
//    private Set<Role> role;

//    public int getId_account() {
//        return id_account;
//    }
//
//    public void setId_account(int id_account) {
//        this.id_account = id_account;
//    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getAccess() {
        return access;
    }

    public void setAccess(byte access) {
        this.access = access;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Account(int id_account, String username, String password, byte access, Set<Role> role) {
//        this.id_account = id_account;
        this.username = username;
        this.password = password;
        this.access = access;
        this.role = role;
    }

    public Account() {
    }
}
