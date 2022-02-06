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
import java.util.Arrays;

public class GUI extends JFrame implements ActionListener{
    JTextField tf1, tf2;
    String thumbnailUrl1 = "";
    String thumbnailUrl2 = "";
    String thumbnailUrl3 = "";
    String APIKey = "";
    String searchTerm = "";
    String title1 = "";
    String title2 = "";
    String title3 = "";
    int likes1 = 0;
    int likes2 = 0;
    int likes3 = 0;
    int dislikes1 = 0;
    int dislikes2 = 0;
    int dislikes3 = 0;
    int views1 = 0;
    int views2 = 0;
    int views3 = 0;
    int ratio1 = 0;
    int ratio2 = 0;
    int ratio3 = 0;
    String channel1 = "";
    String channel2 = "";
    String channel3 = "";
    String pub1 = "";
    String pub2 = "";
    String pub3 = "";
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
        likes1 = videoInfo.get(0).getLikes();
        likes2 = videoInfo.get(1).getLikes();
        likes3 = videoInfo.get(2).getLikes();
        dislikes1 = videoInfo.get(0).getDislikes();
        dislikes2 = videoInfo.get(1).getDislikes();
        dislikes3 = videoInfo.get(2).getDislikes();
        views1 = videoInfo.get(0).getViewCount();
        views2 = videoInfo.get(1).getViewCount();
        views3 = videoInfo.get(2).getViewCount();
        ratio1 = videoInfo.get(0).getLikes()/(videoInfo.get(0).getDislikes() + 1);
        ratio2 = videoInfo.get(1).getLikes()/(videoInfo.get(1).getDislikes() + 1);
        ratio3 = videoInfo.get(2).getLikes()/(videoInfo.get(2).getDislikes() + 1);
        title1 = rawVideo.get(0).getTitle();
        title2 = rawVideo.get(1).getTitle();
        title3 = rawVideo.get(2).getTitle();
        channel1 = rawVideo.get(0).getChannel();
        channel2 = rawVideo.get(1).getChannel();
        channel3 = rawVideo.get(2).getChannel();
        pub1 = rawVideo.get(0).getPub();
        pub2 = rawVideo.get(1).getPub();
        pub3 = rawVideo.get(2).getPub();
        thumbnailUrl1 = rawVideo.get(0).getThumbnailUrl();
        thumbnailUrl2 = rawVideo.get(1).getThumbnailUrl();
        thumbnailUrl3 = rawVideo.get(2).getThumbnailUrl();
        // thumbnailUrl1 = "https://i.ytimg.com/vi/Xjq0kljBZnY/default.jpg";
        // thumbnailUrl2 = "https://i.ytimg.com/vi/XGD0eGfKwlE/default.jpg";
        // thumbnailUrl3 = "https://i.ytimg.com/vi/uwutHtN-ks0/default.jpg";
        // title1 = "The Story of Microsoft - How a Computer Club Took Over The World";
        // title2 = "In this step-by-step tutorial, find out all about Microsoft 365. Microsoft 365 is a subscription plan that includes the Microsoft Office ...";
        // title3 = "The way we work changes with #HybridWork. Fly through Microsoft's Silicon Valley campus for a glimpse of how employees flow ...";
        // likes1 = 0;
        // likes2 = 0;
        // likes3 = 0;
        // dislikes1 = 0;
        // dislikes2 = 0;
        // dislikes3 = 0;
        // views1 = 0;
        // views2 = 0;
        // views3 = 0;
        // ratio1 = 0;
        // ratio2 = 0;
        // ratio3 = 0;
        // channel1 = "Jack Chapple";
        // channel2 = "Kevin Stratvert";
        // channel3 = "Microsoft";
        // pub1 = "2019-10-29T15:00:05Z";
        // pub2 = "2021-02-18T08:00:07Z";
        // pub3 = "2021-10-07T16:47:13Z";
        // url1 = "Xjq0kljBZnY";
        // url2 = "XGD0eGfKwlE";
        // url3 = "uwutHtN-ks0";
        Icon thumbnnailIcon1;
        try {
            thumbnnailIcon1 = new ImageIcon(new URL(thumbnailUrl1));
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
            JLabel l3 = new JLabel(title1);
            l3.setBounds(140,80,400,30);
            f.add(l3);
            JLabel l6 = new JLabel(Integer.toString(views1) + " views");
            l6.setBounds(140,120,100,30);
            f.add(l6);
            JLabel l7 = new JLabel("Ratio: " + Integer.toString(ratio1));
            l7.setBounds(250,120,70,30);
            f.add(l7);
            JLabel l8 = new JLabel("Likes:" + Integer.toString(likes1));
            l8.setBounds(330,120,100,30);
            f.add(l8);
            JLabel l9 = new JLabel("Dislikes: " + Integer.toString(dislikes1));
            l9.setBounds(440,120,100,30);
            f.add(l9);
            JLabel l10 = new JLabel(channel1);
            l10.setBounds(140,100,300,30);
            f.add(l10);
            JLabel l11 = new JLabel(pub1);
            l11.setBounds(140,140,200,30);;
            f.add(l11);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon2;
        try {
            thumbnnailIcon2 = new ImageIcon(new URL(thumbnailUrl2));
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
            JLabel l4 = new JLabel(title2);
            l4.setBounds(140,180,400,30);
            f.add(l4);
            JLabel l12 = new JLabel(Integer.toString(views2) + " views");
            l12.setBounds(140,220,100,30);
            f.add(l12);
            JLabel l13 = new JLabel("Ratio: " + Integer.toString(ratio2));
            l13.setBounds(250,220,70,30);
            f.add(l13);
            JLabel l14 = new JLabel("Likes:" + Integer.toString(likes2));
            l14.setBounds(330,220,100,30);
            f.add(l14);
            JLabel l15 = new JLabel("Dislikes: " + Integer.toString(dislikes2));
            l15.setBounds(440,220,100,30);
            f.add(l15);
            JLabel l16 = new JLabel(channel2);
            l16.setBounds(140,200,300,30);
            f.add(l16);
            JLabel l17 = new JLabel(pub2);
            l17.setBounds(140,240,200,30);;
            f.add(l17);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        Icon thumbnnailIcon3;
        try {
            thumbnnailIcon3 = new ImageIcon(new URL(thumbnailUrl3));
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
            JLabel l5 = new JLabel(title3);
            l5.setBounds(140,280,400,30);
            f.add(l5);
            JLabel l18 = new JLabel(Integer.toString(views3) + " views");
            l18.setBounds(140,320,100,30);
            f.add(l18);
            JLabel l19 = new JLabel("Ratio: " + Integer.toString(ratio3));
            l19.setBounds(250,320,70,30);
            f.add(l19);
            JLabel l20 = new JLabel("Likes:" + Integer.toString(likes3));
            l20.setBounds(330,320,100,30);
            f.add(l20);
            JLabel l21 = new JLabel("Dislikes: " + Integer.toString(dislikes3));
            l21.setBounds(440,320,100,30);
            f.add(l21);
            JLabel l22 = new JLabel(channel3);
            l22.setBounds(140,300,300,30);
            f.add(l22);
            JLabel l23 = new JLabel(pub3);
            l23.setBounds(140,340,200,30);;
            f.add(l23);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        f.setVisible(true);
    }
}
