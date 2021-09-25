package lab3;

import lab3.chordal.Chordal;
import lab3.chordal.mammal.Mammal;
import lab3.chordal.mammal.harelike.HareLike;
import lab3.chordal.mammal.harelike.leporidae.Leporidae;
import lab3.chordal.mammal.harelike.leporidae.Pentalagus;
import lab3.chordal.mammal.harelike.ochotonidae.Ochotona;
import lab3.chordal.mammal.harelike.ochotonidae.Ochotonidae;
import lab3.chordal.mammal.pinnipeds.Pinnipeds;
import lab3.chordal.mammal.pinnipeds.odobenidae.Odobenidae;
import lab3.chordal.mammal.pinnipeds.odobenidae.Odobenus;
import lab3.chordal.mammal.pinnipeds.phocidae.Mirounga;
import lab3.chordal.mammal.pinnipeds.phocidae.Phocidae;
import lab3.queue.Queue;
import lab3.queue.exceptions.QueueOverflowException;
import lab3.queue.exceptions.QueueUnderflowException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Queue<Chordal> queue = new Queue<>(12);
        try {
            fill(queue);
            Queue<HareLike> producible = produce(queue);
            System.out.println(producible);
            ArrayList<Queue<HareLike>> consumed = consume(producible);
            System.out.println(consumed);
        } catch (QueueOverflowException | QueueUnderflowException e) {
            e.printStackTrace();
        }
    }

    public static Queue<HareLike> produce(Queue<? extends Chordal> chordalQueue)
            throws QueueUnderflowException, QueueOverflowException {
        if (chordalQueue == null) {
            return null;
        }
        Queue<HareLike> queue = new Queue<>(chordalQueue.size());
        while (!chordalQueue.isEmpty()) {
            Chordal temp = chordalQueue.remove();
            if (temp instanceof HareLike) {
                queue.add((HareLike) temp);
            }
        }
        return queue;
    }

    public static ArrayList<Queue<HareLike>> consume(Queue<? extends Chordal> chordalQueue)
            throws QueueUnderflowException, QueueOverflowException {
        if (chordalQueue == null) {
            return null;
        }
        final Queue<HareLike> ochotonidaeQueue = new Queue<>(chordalQueue.size());
        final Queue<HareLike> leporidaeQueue = new Queue<>(chordalQueue.size());
        while (!chordalQueue.isEmpty()) {
            Chordal temp = chordalQueue.remove();
            if (temp instanceof Ochotonidae) {
                ochotonidaeQueue.add((Ochotonidae) temp);
            } else if (temp instanceof Leporidae) {
                leporidaeQueue.add((Leporidae) temp);
            }
        }
        final ArrayList<Queue<HareLike>> arrayList = new ArrayList<>(2);
        arrayList.add(ochotonidaeQueue);
        arrayList.add(leporidaeQueue);
        return arrayList;
    }

    private static void fill(Queue<Chordal> chordalQueue) throws QueueOverflowException {
        chordalQueue.add(new HareLike());
        chordalQueue.add(new Chordal());
        chordalQueue.add(new Mammal());
        chordalQueue.add(new Ochotonidae());
        chordalQueue.add(new Ochotona());
        chordalQueue.add(new Leporidae());
        chordalQueue.add(new Pentalagus());
        chordalQueue.add(new Odobenidae());
        chordalQueue.add(new Odobenus());
        chordalQueue.add(new Pinnipeds());
        chordalQueue.add(new Phocidae());
        chordalQueue.add(new Mirounga());
    }
}
