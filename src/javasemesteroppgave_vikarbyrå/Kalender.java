/*Gruppemedlemmene:
Andreas Stenseng Bjørnrud, studentnummer: s236654, INFORMATIK14HA
Jørgen Dyhre, studentnummer: s236647, INFORMATIK14HA
Arthur Nordnes, studentnummer: S236644, INFORMATIK14HA*/

//Sist endret 3. Mai 2015 AV: Andreas Stenseng Bjørnrud
package javasemesteroppgave_vikarbyrå;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

//Konstruktøren til kalenderen
public class Kalender extends JPanel {

	protected int åå;//Aktiverte år
	protected int mm;//aktiverte måned
	protected int dd;//aktiverte dag
	Date datoen = null; //Valgte dato
	int xx = 1;

	protected JButton knapper[][];//Dato-rutene
	protected int innrykk = 0;//Antall ruter som skal være blanke før første dagen i måneden

	Calendar kalender = new GregorianCalendar();//Kalender objektet som skal brukes

	protected final int iÅr = kalender.get(Calendar.YEAR);//Dagens år
	protected final int iMåned = kalender.get(Calendar.MONTH);//Dagens måned
	public boolean valgtdato = false;

	private JButton b0;//En av knappene, brukes kun som referense for getBakgrunn();

	private JComboBox månedListe;//Liste for å velge måned
	private JComboBox årListe;//Liste for å velge år

//Konstruktøren, starter med datoen idag
	public Kalender() {

		super();
		setÅÅMMDD(kalender.get(Calendar.YEAR), kalender.get(Calendar.MONTH), kalender.get(Calendar.DAY_OF_MONTH));
		tegnGUI();
		kalkuler();
	}

//Oppretter kalenderen etter gitt dato, måned og år
	Kalender(int år, int måned, int dag) {

		super();
		setÅÅMMDD(år, måned, dag);
		tegnGUI();
		kalkuler();
	}

	private void setÅÅMMDD(int år, int måned, int dag) {

		åå = år;
		mm = måned;
		dd = dag;
	}

	String[] måneder = { "Januar", "Februar", "Mars", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Desember" };

	//Metode som tegner GUI. Den går ut ifra at setÅÅMMDD er blitt kalt

	private void tegnGUI() {

		getAccessibleContext().setAccessibleDescription("Kalender ikke tilgjengelig");
		setBorder(BorderFactory.createEtchedBorder());

		setLayout(new BorderLayout());

		JPanel p1 = new JPanel();

		p1.add(månedListe = new JComboBox());

		for (int i = 0; i < måneder.length; i++)
			månedListe.addItem(måneder[i]);

		månedListe.setSelectedItem(måneder[mm]);
		månedListe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int i = månedListe.getSelectedIndex();
				if (i >=0) {
					mm = i;

					kalkuler();
				}
			}
		});

		månedListe.getAccessibleContext().setAccessibleName("Måneder");
		månedListe.getAccessibleContext().setAccessibleDescription("Velg en måned");

		p1.add(årListe = new JComboBox());
		årListe.setEditable(true);

		for(int i = åå; i < åå + 2; i++)
			årListe.addItem(Integer.toString(i));
		årListe.setSelectedItem(Integer.toString(åå));
		årListe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int i = årListe.getSelectedIndex();
				if( i >= 0) {
					åå = Integer.parseInt(årListe.getSelectedItem().toString());

					kalkuler();
				}
			}
		});

		add(BorderLayout.CENTER, p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(7,7));
		knapper = new JButton[6][7];//Første raden er dager

		p2.add( b0 = new JButton("Søn"));
		p2.add(new JButton("Man"));
		p2.add(new JButton("Tirs"));
		p2.add(new JButton("Ons"));
		p2.add(new JButton("Tors"));
		p2.add(new JButton("Fre"));
		p2.add(new JButton("Lør"));

		ActionListener datoSetter = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String n = e.getActionCommand();

				if(!n.equals("")) {
// Setter valgte datoen rød
					setAktivDato(Integer.parseInt(n));

					datoen = new Date(åå-1900,mm,dd);//Oppretter en ny valgt dato
					++xx;//Hjelpevariabel for å vite om brukeren har valgt en dato
					//validering
					if(datoen.before(new Date()))
					JOptionPane.showMessageDialog(null, "Vennligst velg en fremtidig dato");

					if(xx != 1 && datoen != null && !datoen.before(new Date()))
					valgtdato = true;

				}
			}
		};

		//Lager knapper, og legger dem til:

		for (int i = 0; i < 6; i++) {

			for(int j = 0; j < 7; j++) {

				p2.add(knapper[i][j] = new JButton(""));
				knapper[i][j].addActionListener(datoSetter);
			}
		}

		add(BorderLayout.SOUTH, p2);
	}

	public final static int antDager[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//Antall dager per måned

	//Metode som kalkulerer hvor hver dag skal plasseres i kalenderen
	protected void kalkuler() {

		if(mm < 0 || mm > 11)
		throw new IllegalArgumentException("Måneden " + mm + " er ikke en måned, den må være mellomn 0 og 11");
		klargjør();
		kalender = new GregorianCalendar(åå, mm, dd);

		// Regner ut innrykket
		innrykk = new GregorianCalendar(åå, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;

		int dagerIMåneden = antDager[mm];
		if(erSkuddår(kalender.get(Calendar.YEAR)) && mm == 1)
		++dagerIMåneden;

		//Metode somn skjuler knappene foran første dagen i måneden
		for(int i = 0; i < innrykk; i++) {
			knapper[0][i].setText("");
		}

		//Fyller inn tall for alle datoene
		for(int i = 1; i <= dagerIMåneden; i++) {

			JButton b = knapper[(innrykk + i - 1) / 7][(innrykk + i - 1) % 7];
			b.setText(Integer.toString(i));
		}

// dager/uka * opp til 6 rader
		for(int i = innrykk + 1 + dagerIMåneden; i < 6*7; i++) {
			knapper[(i) / 7][(i) % 7].setText("");
		}

//Markerer aktive dato
		if(iÅr == åå && mm == iMåned)
		setAktivDato(dd);

		repaint();
	}

//Metode som returnerer true hvis et gitt år er et skuddår
	public boolean erSkuddår(int år) {

		if(år % 4 == 0 && år % 100 != 0 || år % 400 == 0)
		return true;

		return false;
	}

//Setmetode for år måned og dag
	public void setDato(int åå, int mm, int dd) {

		this.åå = åå;
		this.mm = mm;
		this.dd = dd;
		kalkuler();
	}

//Oppdaterer en tidligere markert dato
	private void klargjør() {

		JButton b;

		if (aktivDato > 0) {

			b = knapper[(innrykk + aktivDato - 1) / 7][(innrykk + aktivDato - 1) %7];
			b.setBackground(b0.getBackground());
			b.repaint();
			aktivDato = -1;
		}
	}

	private int aktivDato = -1;

//Setter aktive dato
	public void setAktivDato(int nyDato) {

		klargjør();

//Setter ny dato
		if(nyDato <= 0)
		dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		else
		dd = nyDato;

//Farger den riktige ruta
		Component box = knapper[(innrykk + nyDato - 1) / 7][(innrykk + nyDato - 1) % 7];
		box.setBackground(Color.red);
		box.repaint();

		aktivDato = nyDato;
	}

//Returnerer den valgte datoen
	public Date getDato() {

		return datoen;

	}

	public boolean valgtDato() {

		return valgtdato;
	}


}









