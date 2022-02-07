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
    JTextField tf1, tf2;
    String APIKey = "";
    String searchTerm = "";
    String url1 = "";
    String url2 = "";
    String url3 = "";
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
            JButton b3 = new JButton(thumbnnailIcon1);
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
            JLabel l3 = new JLabel(rawVideo.get(0).getTitle());
            l3.setBounds(140,80,400,30);
            f.add(l3);
            JLabel l6 = new JLabel(Integer.toString(videoInfo.get(0).getViewCount()) + " views");
            l6.setBounds(140,120,100,30);
            f.add(l6);
            JLabel l7 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(0).getLikes()/(videoInfo.get(0).getDislikes() + 1)));
            l7.setBounds(250,120,70,30);
            f.add(l7);
            JLabel l8 = new JLabel("Likes:" + Integer.toString(videoInfo.get(0).getLikes()));
            l8.setBounds(330,120,100,30);
            f.add(l8);
            JLabel l9 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(0).getDislikes()));
            l9.setBounds(440,120,100,30);
            f.add(l9);
            JLabel l10 = new JLabel(rawVideo.get(0).getChannel());
            l10.setBounds(140,100,300,30);
            f.add(l10);
            JLabel l11 = new JLabel(rawVideo.get(0).getPub());
            l11.setBounds(140,140,200,30);;
            f.add(l11);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon2;
        try {
            thumbnnailIcon2 = new ImageIcon(new URL(rawVideo.get(1).getThumbnailUrl()));
            JButton b4 = new JButton(thumbnnailIcon2);
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
            JLabel l4 = new JLabel(rawVideo.get(1).getTitle());
            l4.setBounds(140,180,400,30);
            f.add(l4);
            JLabel l12 = new JLabel(Integer.toString(videoInfo.get(1).getViewCount()) + " views");
            l12.setBounds(140,220,100,30);
            f.add(l12);
            JLabel l13 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(1).getLikes()/(videoInfo.get(1).getDislikes() + 1)));
            l13.setBounds(250,220,70,30);
            f.add(l13);
            JLabel l14 = new JLabel("Likes:" + Integer.toString(videoInfo.get(1).getLikes()));
            l14.setBounds(330,220,100,30);
            f.add(l14);
            JLabel l15 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(1).getDislikes()));
            l15.setBounds(440,220,100,30);
            f.add(l15);
            JLabel l16 = new JLabel(rawVideo.get(1).getChannel());
            l16.setBounds(140,200,300,30);
            f.add(l16);
            JLabel l17 = new JLabel(rawVideo.get(1).getPub());
            l17.setBounds(140,240,200,30);;
            f.add(l17);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon3;
        try {
            thumbnnailIcon3 = new ImageIcon(new URL(rawVideo.get(2).getThumbnailUrl()));
            JButton b5 = new JButton(thumbnnailIcon3);
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
            JLabel l5 = new JLabel(rawVideo.get(2).getTitle());
            l5.setBounds(140,280,400,30);
            f.add(l5);
            JLabel l18 = new JLabel(Integer.toString(videoInfo.get(2).getViewCount()) + " views");
            l18.setBounds(140,320,100,30);
            f.add(l18);
            JLabel l19 = new JLabel("Ratio: " + Integer.toString(videoInfo.get(2).getLikes()/(videoInfo.get(2).getDislikes() + 1)));
            l19.setBounds(250,320,70,30);
            f.add(l19);
            JLabel l20 = new JLabel("Likes:" + Integer.toString(videoInfo.get(2).getLikes()));
            l20.setBounds(330,320,100,30);
            f.add(l20);
            JLabel l21 = new JLabel("Dislikes: " + Integer.toString(videoInfo.get(2).getDislikes()));
            l21.setBounds(440,320,100,30);
            f.add(l21);
            JLabel l22 = new JLabel(rawVideo.get(2).getChannel());
            l22.setBounds(140,300,300,30);
            f.add(l22);
            JLabel l23 = new JLabel(rawVideo.get(2).getPub());
            l23.setBounds(140,340,200,30);;
            f.add(l23);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        f.setVisible(true);
    }
}
