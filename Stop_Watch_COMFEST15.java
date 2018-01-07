import java.awt.*;
public class Stop_Watch_COMFEST15 extends java.applet.Applet
{
    int hrs=0;
    int min=0;
    int sec=0;
    String permission="";
    String HRS="";
    String MIN="";
    String SEC="";
    Font f1=new Font ("Digital-7 Mono",Font.PLAIN,120);
    Font f2=new Font ("Digital-7 Mono",Font.PLAIN,50);
    Button S=new Button("START");
    Button SS=new Button("RESET");
    Button SSS=new Button("PAUSE");
    TextArea tf=new TextArea("MESSAGE");
    Image START;
    Image START1;
    Image START3;
    public void init()
    {
        resize(1366,768);
        setLayout(null);
        S.setSize(75,30);
        S.setLocation(50,180);
        SS.setSize(75,30);
        SS.setLocation(150,180);      
        SSS.setSize(75,30);
        SSS.setLocation(250,180);      
        tf.setSize(800,200);
        tf.setLocation(50,380);
        tf.setForeground(Color.white);
        tf.setBackground(new Color(21,59,82));
        add(S);
        add(SS);
        add(SSS);
        add(tf);
        tf.setFont(f2);
    }

    public void paint(Graphics g)
    {
        START1=getImage(getCodeBase(),"IMAGES/BACKGROUND1.jpg");
        //g.drawImage(START1,0,0,1280,800,this);
        START=getImage(getCodeBase(),"IMAGES/BACKGROUND.png");
        g.drawImage(START,0,0,1366,768,this);
        START3=getImage(getCodeBase(),"IMAGES/timer.jpg");
        //g.drawImage(START3,40,2,600,110,this);
        g.setColor(Color.white);
        if(permission=="Stop"||permission=="")
        {
            hrs=0;
            min=0;
            sec=0;
            g.setFont(f1);
            if(hrs>9)
                HRS=String.valueOf(hrs);
            else
                HRS="0"+String.valueOf(hrs);
            if(min>9)
                MIN=String.valueOf(min);
            else
                MIN="0"+String.valueOf(min);
            if(sec>9)
                SEC=String.valueOf(sec);
            else
                SEC="0"+String.valueOf(sec);
            g.drawString(HRS+":"+MIN+":"+SEC,180,325);
        }
        if(permission=="Start")
        {
            g.setFont(f1);
            if(hrs>9)
                HRS=String.valueOf(hrs);
            else
                HRS="0"+String.valueOf(hrs);
            if(min>9)
                MIN=String.valueOf(min);
            else
                MIN="0"+String.valueOf(min);
            if(sec>9)
                SEC=String.valueOf(sec);
            else
                SEC="0"+String.valueOf(sec);
            g.drawString(HRS+":"+MIN+":"+SEC,180,325);
            sec++;
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {}
            if(sec>=60)
            {
                min++;
                sec=0;
            }
            if(min>=60)
            {
                hrs++;
                min=0;
            }
            repaint();
        }
        if(permission=="Pause")
        {     
            g.setFont(f1);
            if(hrs>9)
                HRS=String.valueOf(hrs);
            else
                HRS="0"+String.valueOf(hrs);
            if(min>9)
                MIN=String.valueOf(min);
            else
                MIN="0"+String.valueOf(min);
            if(sec>9)
                SEC=String.valueOf(sec);
            else
                SEC="0"+String.valueOf(sec);
            g.drawString(HRS+":"+MIN+":"+SEC,180,325);
        }
    }

    public boolean action(Event evt, Object arg)
    {
        if(evt.target instanceof Button)
        {
            if(arg.equals("START"))
            {
                permission="Start";
                repaint();
            }
        }
        if(arg.equals("RESET"))
        {
            permission="Stop";
            repaint();
        }
        if(arg.equals("PAUSE"))
        {
            permission="Pause";
            repaint();
        }
        return true;
    }
}