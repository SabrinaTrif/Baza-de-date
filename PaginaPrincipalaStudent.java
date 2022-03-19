import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;
public class PaginaPrincipalaStudent {
	Connection con;
	private static JFrame frame;
	int x;
	int y;

	JTextArea orar;

	PaginaPrincipalaStudent(int x,int y,String nume,String prenume,Connection c){
		con=c;
		frame=new JFrame("Pagina "+nume+" "+prenume);
		this.x=x-10;
		this.y=y+10;
		frame.setLocation(this.x,this.y);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(600,320);
		
		
		
		JLabel sal=new JLabel("Bine ai venit "+nume+" "+prenume);
		sal.setFont(new Font("", Font.BOLD, 20));
		JLabel data=new JLabel("data:");
		JLabel orar_mess=new JLabel("Orarul pentru astazi:");

		JButton info=new JButton("Vizualizare info");
		//info.setPreferredSize(new Dimension(26,100));
		JButton curs=new JButton("Cursuri");
		//curs.setPreferredSize(new Dimension(26,100));
		JButton grup=new JButton("Grupuri de studiu");
		//grup.setPreferredSize(new Dimension(26,100));
		JButton note=new JButton("Note");
		//note.setPreferredSize(new Dimension(26,100));
		JButton decon=new JButton("Deconectare");
		decon.setForeground(Color.red);
		
		decon.addActionListener(new DeconectListener());
		
		orar=new UneditableJTextArea("ora:curs,activitate,profesor\n");
		orar.setFont(new Font("Seqoe Script",Font.BOLD,12));
		
		JPanel sus=new JPanel();
		sus.add(sal);
		sus.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel eticheteZi=new JPanel();

		eticheteZi.add(Box.createHorizontalStrut(1));
		eticheteZi.add(data);
		eticheteZi.add(Box.createHorizontalStrut(110));
		eticheteZi.add(orar_mess);
		eticheteZi.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel butoane=new JPanel();
		JPanel mijloc=new JPanel();
		orar.setColumns(5);
		//orar.set

		//butoane.add(sal);

		butoane.add(Box.createRigidArea(new Dimension(20,0)));
		butoane.add(info);
		butoane.add(Box.createRigidArea(new Dimension(0,10)));
		butoane.add(curs);
		butoane.add(Box.createRigidArea(new Dimension(0,10)));
		butoane.add(grup);
		butoane.add(Box.createRigidArea(new Dimension(0,10)));
		butoane.add(note);
		butoane.add(Box.createRigidArea(new Dimension(0,10)));
		butoane.setLayout(new BoxLayout(butoane,BoxLayout.Y_AXIS));

		mijloc.setLayout(new BorderLayout(10,0));

		mijloc.add(butoane,BorderLayout.LINE_START);
		butoane.add(Box.createHorizontalGlue());
		mijloc.add(orar,BorderLayout.CENTER);
		JPanel jos=new JPanel();
		jos.add(decon);
		jos.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JPanel p=new JPanel();
		
		p.add(sus);
		p.add(Box.createRigidArea(new Dimension(0,30)));
		p.add(eticheteZi);
		p.add(mijloc);
		
		p.add(jos);

		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));


		frame.setContentPane(p);
		frame.setVisible(true);
	}
	class DeconectListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Logare log=new Logare(con);
			frame.dispose();
		}
	}

}
