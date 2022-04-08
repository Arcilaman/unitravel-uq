package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsusarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrar(){
        Usuario usuario = new Usuario("92882", "Pepito", "pepe@gmail.com", "72782");
       Usuario usuarioGuardado = usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminar(){
        Usuario usuario = new Usuario("92882", "Pepito", "pepe@gmail.com", "72782");
        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        usuarioRepo.delete(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("92882").orElse(null);
        Assertions.assertNull(usuarioBuscado);
    }

    @Test
    public void actualizar(){
        Usuario usuario = new Usuario("92882", "Pepito", "pepe@gmail.com", "72782");

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        usuarioGuardado.setPassword("abc123");

        usuarioRepo.save(usuarioGuardado);

        Usuario usuarioBuscado = usuarioRepo.findById("92882").orElse(null);
        Assertions.assertEquals("abc123", usuarioBuscado.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
//        Usuario usuario = new Usuario("92882", "Pepito", "pepe@gmail.com", "72782");
//        usuarioRepo.save(usuario);
//
//        Usuario usuario2 = new Usuario("45666", "Pepito", "pepe2@gmail.com", "72782");
//        usuarioRepo.save(usuario2);
//
//        Usuario usuario3 = new Usuario("34534", "Pepito", "pepe3@gmail.com", "72782");
//        usuarioRepo.save(usuario3);

        List<Usuario> usuarios = usuarioRepo.findAll();

        System.out.println(usuarios);
    }

}
