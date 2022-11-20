import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
class clc extends JFrame implements KeyListener,ActionListener{
	private static final long serialVersionUID = 1L;
	int cs=38,v=25,po=0;
    JLabel l,ans,en;
    JTextArea ta;
    JPanel p=null;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bp,bm,bmu,bd,b0,be,bw,bc,br,previous=null;
    GridBagConstraints gbc=new GridBagConstraints();
    Stack<Character> st=new Stack<Character>();
    Stack<Long> ev=new Stack<>();
    clc(){
        addKeyListener(this);
        this.setLayout(new GridBagLayout());
        l=new JLabel("Calculator",JLabel.CENTER);
        l.setFont(new FontUIResource("BOLD",Font.PLAIN,25));
        l.setForeground(Color.RED);
        gbc.ipadx=300;
        gbc.ipady=50;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.FIRST_LINE_START;
        this.add(l,gbc);
        ans=new JLabel();
        ans.setFont(new FontUIResource("BOLD",Font.PLAIN,20));
        ans.setForeground(Color.green);
        gbc.ipadx=300;
        gbc.ipady=30;
        gbc.gridx=0;
        gbc.gridy=1;
        this.add(ans,gbc);
        en=new JLabel();
        en.setHorizontalTextPosition(JLabel.RIGHT);
        en.setVerticalTextPosition(JLabel.BOTTOM);
        en.setForeground(Color.red);
        gbc.ipadx=300;
        gbc.ipady=40;
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(en,gbc);
        en.addKeyListener(this);
        p=new JPanel();
        this.setSize(300,430);
        gbc.ipadx=300;
        gbc.ipady=300;
        gbc.gridx=0;
        gbc.gridy=3;
        this.add(p,gbc);
        p.addKeyListener(this);
        b1=new JButton("1");
        b1.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        b2=new JButton("2");
        b2.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        bp=new JButton("+");
        bp.setFont(new FontUIResource("BOLd",Font.PLAIN,20));
        b3=new JButton("3");
        b3.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        b4=new JButton("4");
        b4.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        bm=new JButton("-");
        bm.setFont(new FontUIResource("BOLd",Font.PLAIN,20));
        b5=new JButton("5");
        b5.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        b6=new JButton("6");
        b6.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        bmu =new JButton("*");
        bmu.setFont(new FontUIResource("BOLD",Font.PLAIN,20));
        b7=new JButton("7");
        b7.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        b8=new JButton("8");
        b8.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        bd=new JButton("/");
        bd.setFont(new FontUIResource("BOLd",Font.PLAIN,20));
        b9=new JButton("9");
        b9.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        b0=new JButton("0");
        b0.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        be=new JButton("Enter");
        be.setFont(new FontUIResource("BOLd",Font.PLAIN,15));
        bw=new JButton("BackSpace");
        bw.setFont(new FontUIResource("BOLD",Font.PLAIN,15));
        bc=new JButton("Clear");
        bc.setFont(new FontUIResource("BOLD",Font.PLAIN,15));
        br=new JButton("%");
        br.setFont(new FontUIResource("BOLD",Font.PLAIN,20));
        p.add(b1);
        p.add(b2);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bp);
        p.add(b0);
        p.add(bm);
        p.add(bmu);
        p.add(bd);
        p.add(br);
        p.add(bw);
        p.add(bc);
        p.add(be);
        br.addActionListener(this);
        bw.addActionListener(this);
        bc.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        be.addActionListener(this);
        b0.addActionListener(this);
        bp.addActionListener(this);
        bm.addActionListener(this);
        bmu.addActionListener(this);
        bd.addActionListener(this);
        p.addKeyListener(this);
        p.setLayout(new GridLayout(6,3,3,3));
        this.setSize(300,500);
        this.setTitle("Ravi");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
    }
    @Override
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void actionPerformed(ActionEvent e){
        if(en.getText().length()<=38){
            en.setFont(new FontUIResource("BOLD",Font.PLAIN,25));
            System.out.println(en.getText().length());
        }
        else if((en.getText().length())%(40)==0 || en.getText().length()%(this.cs+8*po)==0){
            this.po=po+1;
            this.v=this.v-5;
            this.cs=this.cs+po*8;
            en.setFont(new FontUIResource("BOLD",Font.PLAIN,this.v));
        }
        if(!(ans.getText()).equals("")){
            ans.setText("");
            en.setText("");
        }
        if(e.getSource()==bp){
            String s=en.getText();
            bp.setBackground(Color.magenta);
            if(previous!=null) previous.setBackground(null);
            previous=bp;
            s=s+"+";
            en.setText(s);
        }
        else if(e.getSource()==bm){
            String s=en.getText();
            bm.setBackground(Color.red);
            if(previous!=null) previous.setBackground(null);
            previous=bm;
            s=s+"-";
            en.setText(s);
        }
        else if(e.getSource()==bmu){
            String s=en.getText();
            bmu.setBackground(Color.green);
            if(previous!=null) previous.setBackground(null);
            previous=bmu;
            s=s+"*";
            en.setText(s);
        }
        else if(e.getActionCommand()=="/"){
            String s=en.getText();
            bd.setBackground(Color.pink);
            if(previous!=null) previous.setBackground(null);
            previous=bd;
            s=s+"/";
            en.setText(s);
        }
        else if(e.getSource()==b0){
            String s=en.getText();
            b0.setBackground(Color.gray);
            if(previous!=null) previous.setBackground(null);
            previous=b0;
            s=s+"0";
            en.setText(s);
        }
        else if(e.getSource()==b1){
            String s=en.getText();
            b1.setBackground(Color.orange);
            if(previous!=null) previous.setBackground(null);
            previous=b1;
            s=s+"1";
            en.setText(s);
        }
        else if(e.getSource()==b2){
            String s=en.getText();
            b2.setBackground(Color.blue);
            if(previous!=null) previous.setBackground(null);
            previous=b2;
            s=s+"2";
            en.setText(s);
        }
        else if(e.getSource()==b3){
            String s=en.getText();
            b3.setBackground(Color.magenta);
            if(previous!=null) previous.setBackground(null);
            previous=b3;
            s=s+"3";
            en.setText(s);
        }
        else if(e.getSource()==b4){
            String s=en.getText();
            b4.setBackground(Color.gray);
            if(previous!=null) previous.setBackground(null);
            previous=b4;
            s=s+"4";
            en.setText(s);
        }
        else if(e.getSource()==b5){
            String s=en.getText();
            b5.setBackground(Color.red);
            if(previous!=null) previous.setBackground(null);
            previous=b5;
            s=s+"5";
            en.setText(s);
        }
        else if(e.getSource()==b6){
            String s=en.getText();
            b6.setBackground(Color.green);
            if(previous!=null) previous.setBackground(null);
            previous=b6;
            s=s+"6";
            en.setText(s);
        }
        else if(e.getSource()==b7){
            String s=en.getText();
            b7.setBackground(Color.blue);
            if(previous!=null) previous.setBackground(null);
            previous=b7;
            s=s+"6";
            en.setText(s);
        }
        else if(e.getSource()==b8){
            String s=en.getText();
            b8.setBackground(Color.yellow);
            if(previous!=null) previous.setBackground(null);
            previous=b8;
            s=s+"8";
            en.setText(s);
        }
        else if(e.getSource()==b9){
            String s=en.getText();
            b9.setBackground(Color.yellow);
            if(previous!=null) previous.setBackground(null);
            previous=b9;
            s=s+"9";
            en.setText(s);
        }else if(e.getSource()==br){
            String s=en.getText();
            br.setBackground(Color.orange);
            if(previous!=null) previous.setBackground(null);
            previous=br;
            s=s+"%";
            en.setText(s);
        }else if(e.getSource()==bw){
            String s=en.getText();
            bw.setBackground(Color.orange);
            if(previous!=null) previous.setBackground(null);
            previous=bw;
            char c[]=s.toCharArray();
            s="";
            for(int i=0;i<c.length-1;i++){
                s=s+c[i];
            }
            en.setText(s);
        }else if(e.getSource()==bc){
            en.setText("");
            bc.setBackground(Color.pink);
            if(previous!=null) previous.setBackground(null);
            previous=bc;
        }
        else if(e.getSource()==be){
            be.setBackground(Color.blue);
            if(previous!=null) previous.setBackground(null);
            previous=be;
            this.post(en.getText());
        }
    }
    public int pri(char c){
        if(c=='+'||c=='-'){
            return 1;
        }
        else if(c=='*'||c=='/'){
            return 2;
        }
        else if(c=='^'){
            return 3;
        }
        return -1;
    }
    public void post(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                res=res+c;
            }
            else{
                ev.push(Long.parseLong(res));
                res="";
                while(!st.empty()&& this.pri(st.peek())>=this.pri(c)){
                    long v1=ev.pop();
                    long v2=ev.pop();
                    char op=st.pop();
                    if(op=='+'){
                        ev.push(v2+v1);
                    }
                    else if(op=='-'){
                        ev.push(v2-v1);
                    }else if(op=='*'){
                        ev.push(v2*v1);
                    }else if(op=='/'){
                        ev.push(v2/v1);
                    }
                }
                st.push(c);
            }
        }
        if(!res.equals("")){
            ev.push(Long.parseLong(res));
        }
        while(!st.empty()){
            long v1=ev.pop();
            long v2=ev.pop();
            char c=st.pop();
            if(c=='+'){
                ev.push(v2+v1);
            }
            if(c=='-'){
                ev.push(v2-v1);
            }if(c=='*'){
                ev.push(v2*v1);
            }if(c=='/'){
                ev.push(v2/v1);
            }
        }
        ans.setText("Ans="+ev.pop());
    }
}
public class calculator {
    public static void main(String ravi[]){
        new clc();
    }
}

