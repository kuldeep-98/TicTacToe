import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

class TicDialog{
    public TicDialog(Frame f,String message){
        Dialog d = new Dialog(f, "Result", true);
        Button restart = new Button("Restart");
        Button quit = new Button("Quit");

        if (message.equals("1")) message = "Player 1 Wins";
        else if (message.equals("2")) message = "Player 2 Wins";
        else message = message;

        Label result = new Label(message);
        result.setBounds(50, 50, 100, 30);
        restart.setBounds(70, 100, 70, 40);
        quit.setBounds(160, 100, 50, 40);
        restart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                d.dispose();
                f.dispose();
                new TicTacToe();
            }
        });
        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                d.dispose();
                f.dispose();
            }
        });
        d.add(result);
        d.add(restart);
        d.add(quit);
        d.setSize(300, 200);
        d.setLayout(null);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }
}

public class TicTacToe extends Applet {
    private int flag = 1;
    private int x1 = 0, y1 = 0, printX = 0, printY = 0;
    private char[] ch = new char[9];

    Frame f = new Frame("Tic Tac Toe");

    public TicTacToe() {
        Button start = new Button("Start");
        Button quit = new Button("Quit");

        start.setBounds(200, 200, 70, 40);
        quit.setBounds(300, 200, 70, 40);
        f.add(start);
        f.add(quit);
        f.setSize(600, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                f.dispose();
            }
        });

        Graphics g = f.getGraphics();
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.remove(start);
                f.remove(quit);
                g.drawLine(200, 0, 200, 600);
                g.drawLine(400, 0, 400, 600);
                g.drawLine(0, 200, 600, 200);
                g.drawLine(0, 400, 600, 400);
                for (int i = 0; i < 9; i++) ch[i] = ' ';

                f.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        int x = mouseEvent.getX();
                        int y = mouseEvent.getY();

                        if (flag == 1) {
                            if (x < 200 && y < 200 && ch[0] == ' ') {
                                x1 = 20;
                                y1 = 20;
                                ch[0] = '1';
                                printX = 1;
                            } else if ((x > 200 && x < 400) && y < 200 && ch[1] == ' ') {
                                x1 = 220;
                                y1 = 20;
                                ch[1] = '1';
                                printX = 1;
                            } else if ((x > 400 && x < 600) && y < 200 && ch[2] == ' ') {
                                x1 = 420;
                                y1 = 20;
                                ch[2] = '1';
                                printX = 1;
                            } else if (x < 200 && (y > 200 && y < 400) && ch[3] == ' ') {
                                x1 = 20;
                                y1 = 220;
                                ch[3] = '1';
                                printX = 1;
                            } else if ((x > 200 && x < 400) && (y > 200 && y < 400) && ch[4] == ' ') {
                                x1 = 220;
                                y1 = 220;
                                ch[4] = '1';
                                printX = 1;
                            } else if ((x > 400 && x < 600) && (y > 200 && y < 400) && ch[5] == ' ') {
                                x1 = 420;
                                y1 = 220;
                                ch[5] = '1';
                                printX = 1;
                            } else if (x < 200 && (y > 400 && y < 600) && ch[6] == ' ') {
                                x1 = 20;
                                y1 = 420;
                                ch[6] = '1';
                                printX = 1;
                            } else if ((x > 200 && x < 400) && (y > 400 && y < 600) && ch[7] == ' ') {
                                x1 = 220;
                                y1 = 420;
                                ch[7] = '1';
                                printX = 1;
                            } else if ((x > 400 && x < 600) && (y > 400 && y < 600) && ch[8] == ' ') {
                                x1 = 420;
                                y1 = 420;
                                ch[8] = '1';
                                printX = 1;
                            } else return;
                        }

                        if (printX == 1) {
                            g.setColor(Color.BLUE);
                            g.drawLine(x1, y1, x1 + 160, y1 + 160);
                            g.drawLine(x1 + 160, y1, x1, y1 + 160);
                            printX = 0;
                        }

                        if (flag == 0) {
                            if (x < 200 && y < 200 && ch[0] == ' ') {
                                x1 = 20;
                                y1 = 20;
                                ch[0] = '2';
                                printY = 1;
                            } else if ((x > 200 && x < 400) && y < 200 && ch[1] == ' ') {
                                x1 = 220;
                                y1 = 20;
                                ch[1] = '2';
                                printY = 1;
                            } else if ((x > 400 && x < 600) && y < 200 && ch[2] == ' ') {
                                x1 = 420;
                                y1 = 20;
                                ch[2] = '2';
                                printY = 1;
                            } else if (x < 200 && (y > 200 && y < 400) && ch[3] == ' ') {
                                x1 = 20;
                                y1 = 220;
                                ch[3] = '2';
                                printY = 1;
                            } else if ((x > 200 && x < 400) && (y > 200 && y < 400) && ch[4] == ' ') {
                                x1 = 220;
                                y1 = 220;
                                ch[4] = '2';
                                printY = 1;
                            } else if ((x > 400 && x < 600) && (y > 200 && y < 400) && ch[5] == ' ') {
                                x1 = 420;
                                y1 = 220;
                                ch[5] = '2';
                                printY = 1;
                            } else if (x < 200 && (y > 400 && y < 600) && ch[6] == ' ') {
                                x1 = 20;
                                y1 = 420;
                                ch[6] = '2';
                                printY = 1;
                            } else if ((x > 200 && x < 400) && (y > 400 && y < 600) && ch[7] == ' ') {
                                x1 = 220;
                                y1 = 420;
                                ch[7] = '2';
                                printY = 1;
                            } else if ((x > 400 && x < 600) && (y > 400 && y < 600) && ch[8] == ' ') {
                                x1 = 420;
                                y1 = 420;
                                ch[8] = '2';
                                printY = 1;
                            } else return;
                        }

                        if (printY == 1) {
                            flag = 2;
                            g.setColor(Color.RED);
                            g.drawOval(x1 + 20, y1 + 20, 120, 120);
                            printY = 0;
                        }

                        flag--;

                        for (int i = 0; i < 3; i++) {                                                          //for Vertical
                            if (ch[i] != ' ') {
                                if ((ch[i] == ch[i + 3]) && (ch[i] == ch[i + 6])) {
                                    new TicDialog(f,Character.toString(ch[i]));
                                    return;
                                }
                            }
                        }
                        for (int i = 0; i < 7; i++) {                                                          //for horizontal
                            if (ch[i] != ' ') {
                                if ((ch[i] == ch[i + 1]) && (ch[i] == ch[i + 2])) {
                                    new TicDialog(f,Character.toString(ch[i]));
                                    return;
                                }
                            }
                            i = i + 2;
                        }

                        if (ch[4] != ' ')                                                                   //for diagonals
                        {
                            if (((ch[0] == ch[4]) && (ch[4] == ch[8]))) {
                                new TicDialog(f,Character.toString(ch[0]));
                                return;
                            }
                            if (((ch[2] == ch[4]) && (ch[4] == ch[6]))) {
                                new TicDialog(f,Character.toString(ch[2]));
                                return;
                            }
                        }

                        for (int i = 0; i < 9; i++) {
                            if (ch[i] != ' ') {
                                if (i == 8) {
                                    new TicDialog(f,"Match Draw");
                                }
                            } else break;
                        }
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
