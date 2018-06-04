package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.UserView;
import org.jbox2d.common.Vec2;
/**
 * Class that keeps track of heart's view
 * @author darkk
 */
public class HeartTracker implements StepListener {

    private UserView view;

    private Heart body;

    public HeartTracker(UserView view, Heart body) {
        this.view = view;
        this.body = body;

    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {
        view.setView(new Vec2(-14f, -14f), 0);
    }
}
