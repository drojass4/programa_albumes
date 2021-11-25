package co.edu.ucentral.ingsf.springprime.bean;



import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class IndexBean implements Serializable {
    private MenuModel model;
    private List<String> images;


    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 9; i++) {
            images.add("foto"+ i +".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}



