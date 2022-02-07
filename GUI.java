import javax.swing.*;  
import java.awt.event.*;
import java.io.IOException;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class GUI extends JFrame implements ActionListener{
    JButton b3, b4, b5;
    JLabel l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel l11, l12, l13, l14, l15, l16, l17, l18, l19, l20;
    JLabel l21, l22, l23;
    JTextField tf1, tf2;
    String APIKey = "";
    String searchTerm = "";
    String url1, url2, url3 = "";
    JFrame f = new JFrame("YouTube Search");
    GUI() throws MalformedURLException{
        Icon searchIcon = new ImageIcon("images/search.png");
        JButton b1 = new JButton(searchIcon);
        b1.setBounds(325,15,30,30);
        b1.addActionListener(this);
        f.add(b1);
        tf1 = new JTextField();
        tf1.setBounds(10,0,300,30);
        f.add(tf1);
        tf2 = new JTextField("Google API Key");
        tf2.setBounds(10,30,300,30);
        f.add(tf2);
        Icon trashIcon = new ImageIcon("images/trash.png");
        JButton b6 = new JButton(trashIcon);
        b6.setBounds(370,15,30,30);
        b6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        f.setVisible(false);
                        f.remove(l3);f.remove(l4);f.remove(l5);f.remove(l6);f.remove(l7);f.remove(l8);f.remove(l9);f.remove(l10);
                        f.remove(l11);f.remove(l12);f.remove(l13);f.remove(l14);f.remove(l15);f.remove(l16);f.remove(l17);f.remove(l18);f.remove(l19);f.remove(l20);
                        f.remove(l21);f.remove(l22);f.remove(l23);
                        f.remove(b3);f.remove(b4);f.remove(b5);
                        f.setVisible(true);
                    }  
                }); 
        f.add(b6);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(550,410);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        f.setVisible(false);
        ArrayList<Video> videoInfo = new ArrayList<Video>();
        searchTerm = tf1.getText();
        APIKey = tf2.getText();
        System.out.println("Search term: " + searchTerm);
        System.out.println("Google API Key: " + APIKey);
        String search = searchTerm.replace(" ", "%20");
        ArrayList<Video> rawVideo = new ArrayList<Video>();
        try {
            rawVideo = YouTube.getUrl(search, APIKey);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        System.out.println(Video.getNumRawVideo());
        try {
            videoInfo = Dislikes.getRatio(rawVideo);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        url1 = videoInfo.get(0).getID();
        url2 = videoInfo.get(1).getID();
        url3 = videoInfo.get(2).getID();
        Icon thumbnnailIcon1;
        try {
            thumbnnailIcon1 = new ImageIcon(new URL(rawVideo.get(0).getThumbnailUrl()));
            b3 = new JButton(thumbnnailIcon1);
            b3.setBounds(10,80,120,90);
            b3.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                            try{
                                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=" + url1));
                                }
                            }catch (IOException ioe){
                                System.out.println("IOException");
                            }catch (URISyntaxException sej){
                                System.out.println("URISyntaxExceptionJava");
                            }
                        }  
                    }); 
            f.add(b3);
            l3 = new JLabel(rawVideo.get(0).getTitle());
            l3.setBounds(140,80,400,30);
            f.add(l3);
            l6 = new JLabel(Integer.toString(videoInfo.get(0).getViewCount()) + " views");
            l6.setBounds(140,120,100,30);
            f.add(l6);
            l7 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(0).getLikes()/(videoInfo.get(0).getDislikes() + 1)));
            l7.setBounds(250,120,70,30);
            f.add(l7);
            l8 = new JLabel("Likes:" + Integer.toString(videoInfo.get(0).getLikes()));
            l8.setBounds(330,120,100,30);
            f.add(l8);
            l9 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(0).getDislikes()));
            l9.setBounds(440,120,100,30);
            f.add(l9);
            l10 = new JLabel(rawVideo.get(0).getChannel());
            l10.setBounds(140,100,300,30);
            f.add(l10);
            l11 = new JLabel(rawVideo.get(0).getPub());
            l11.setBounds(140,140,200,30);;
            f.add(l11);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon2;
        try {
            thumbnnailIcon2 = new ImageIcon(new URL(rawVideo.get(1).getThumbnailUrl()));
            b4 = new JButton(thumbnnailIcon2);
            b4.setBounds(10,180,120,90);
            b4.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                            try{
                                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=" + url2));
                                }
                            }catch (IOException ioe){
                                System.out.println("IOException");
                            }catch (URISyntaxException sej){
                                System.out.println("URISyntaxExceptionJava");
                            }
                        }  
                    }); 
            f.add(b4);
            l4 = new JLabel(rawVideo.get(1).getTitle());
            l4.setBounds(140,180,400,30);
            f.add(l4);
            l12 = new JLabel(Integer.toString(videoInfo.get(1).getViewCount()) + " views");
            l12.setBounds(140,220,100,30);
            f.add(l12);
            l13 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(1).getLikes()/(videoInfo.get(1).getDislikes() + 1)));
            l13.setBounds(250,220,70,30);
            f.add(l13);
            l14 = new JLabel("Likes:" + Integer.toString(videoInfo.get(1).getLikes()));
            l14.setBounds(330,220,100,30);
            f.add(l14);
            l15 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(1).getDislikes()));
            l15.setBounds(440,220,100,30);
            f.add(l15);
            l16 = new JLabel(rawVideo.get(1).getChannel());
            l16.setBounds(140,200,300,30);
            f.add(l16);
            l17 = new JLabel(rawVideo.get(1).getPub());
            l17.setBounds(140,240,200,30);;
            f.add(l17);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon3;
        try {
            thumbnnailIcon3 = new ImageIcon(new URL(rawVideo.get(2).getThumbnailUrl()));
            b5 = new JButton(thumbnnailIcon3);
            b5.setBounds(10,280,120,90);
            b5.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                            try{
                                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=" + url3));
                                }
                            }catch (IOException ioe){
                                System.out.println("IOException");
                            }catch (URISyntaxException sej){
                                System.out.println("URISyntaxExceptionJava");
                            }
                        }  
                    }); 
            f.add(b5);
            l5 = new JLabel(rawVideo.get(2).getTitle());
            l5.setBounds(140,280,400,30);
            f.add(l5);
            l18 = new JLabel(Integer.toString(videoInfo.get(2).getViewCount()) + " views");
            l18.setBounds(140,320,100,30);
            f.add(l18);
            l19 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(2).getLikes()/(videoInfo.get(2).getDislikes() + 1)));
            l19.setBounds(250,320,70,30);
            f.add(l19);
            l20 = new JLabel("Likes:" + Integer.toString(videoInfo.get(2).getLikes()));
            l20.setBounds(330,320,100,30);
            f.add(l20);
            l21 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(2).getDislikes()));
            l21.setBounds(440,320,100,30);
            f.add(l21);
            l22 = new JLabel(rawVideo.get(2).getChannel());
            l22.setBounds(140,300,300,30);
            f.add(l22);
            l23 = new JLabel(rawVideo.get(2).getPub());
            l23.setBounds(140,340,200,30);;
            f.add(l23);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        f.setVisible(true);
    }
}