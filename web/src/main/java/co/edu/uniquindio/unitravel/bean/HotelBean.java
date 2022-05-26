package co.edu.uniquindio.unitravel.bean;

import co.edu.uniquindio.unitravel.entidades.AdministradorHotel;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Hotel;
import co.edu.uniquindio.unitravel.servicios.AdministradorHotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class HotelBean implements Serializable {


    @Getter
    @Setter
    private Hotel hotel;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @PostConstruct
    public void inicializar(){
        hotel = new Hotel();
    }

    public void registrarHotel()
    {
        try {

            Ciudad ciudad = administradorHotelServicio.obtenerCiudad(1);
            AdministradorHotel admin = administradorHotelServicio.obtenerAdminHotel("1");

            hotel.setCiudad(ciudad);
            hotel.setAdministrador_hotel(admin);

            administradorHotelServicio.crearHotel(hotel);

            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Hotel creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, ms);

        }catch (Exception e){
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, ms);
        }
    }
}
