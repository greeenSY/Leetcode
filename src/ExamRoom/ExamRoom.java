package ExamRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Green on 2018/8/4.
 */
class ExamRoom {
    private List<Integer> seats;
    private int num;
    public ExamRoom(int N) {
        seats = new ArrayList<>();
        num = N;
    }

    public int seat() {
        if(seats.size() == num){
            return -1;
        }
        int pos=0,index=0,max=0;
        for(int i=0; i<=seats.size(); i++){
            int dis=0,t,p;
            if(i == 0){
                t=0;
                p=0;
                if(seats.size() > 0) {
                    dis = seats.get(i) - t;
                }
            } else if(i==seats.size()) {
                t=num-1;
                p=i;
                dis = t - seats.get(i-1);
            } else {
                dis = (seats.get(i) - seats.get(i-1))/2;
                p=i;
                t= seats.get(i-1) + dis;
            }
            if(dis > max){
                max = dis;
                pos = p;
                index = t;
            }
        }
        seats.add(pos, index);
        return index;
    }

    public void leave(int p) {
        seats.remove(seats.lastIndexOf(p));
    }

    public void print(){
        System.out.println(seats);
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(0);
        examRoom.print();
        examRoom.leave(4);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(0);
        examRoom.print();
        examRoom.leave(4);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(7);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(3);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(3);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(9);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(0);
        examRoom.print();
        examRoom.leave(8);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(0);
        examRoom.print();
        examRoom.leave(8);
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.seat();
        examRoom.print();
        examRoom.leave(2);
        examRoom.print();
    }
}
