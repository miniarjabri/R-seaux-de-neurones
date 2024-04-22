package LesCouches;

import LesNeurones.*;
import java.util.List;

public interface Couche<N > {
    int getNombreNeurones();    
    List<N> getNeurones();
    void setNeurones(List<N> neurones);
    String getTypeCouche();
}
