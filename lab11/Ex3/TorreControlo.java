package lab11.Ex3;

import java.util.ArrayList;
import java.util.List;

public class TorreControlo implements IntTorreControlo {
    private List<Aviao> planes;
    private Aviao lastSender;

    public TorreControlo() {
        this.planes = new ArrayList<>();
    }

    @Override
    public void addPlane(Aviao p1) {
        this.planes.add(p1);
    }

    @Override
    public void sendMessage(Aviao sender) {
        this.lastSender = sender;
        for (Aviao plane : planes) {
            if (plane == sender) {
                plane.receiveMessage();
            }
        }
    }
}