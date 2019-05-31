package view;

import contract.ControllerOrder;
import contract.IModel;
import entity.Entity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

/**
 * The Class KeyListener.
 *
 * @author Bastien Aelters, Benjamin Brifault
 */
public class KeyListener extends View implements ActionListener, IModel {


    public KeyListener(IModel modelP) {
        super(modelP);
    }

    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();

        if (keycode == KeyEvent.VK_UP){
            giveOrder(ControllerOrder.MoveUp);
        }

        if (keycode == KeyEvent.VK_DOWN){
            giveOrder(ControllerOrder.MoveDown);
        }

        if (keycode == KeyEvent.VK_LEFT){
            giveOrder(ControllerOrder.MoveLeft);
        }

        if (keycode == KeyEvent.VK_RIGHT){
            giveOrder(ControllerOrder.MoveRight);
        }
    }

    @Override
    public Entity[][] getMap() {
        return new Entity[0][];
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public void giveOrder(ControllerOrder order) {

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getDiamonds_remaining() {
        return 0;
    }

    @Override
    public Observable getObservable() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}