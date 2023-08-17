package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JComboBox religion, category, incomebox, eqbox, occbox;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religions = new JLabel("Religion: ");
        religions.setFont(new Font("Raleway", Font.BOLD, 20));
        religions.setBounds(100, 140, 200, 30);
        add(religions);

        String valrel[] = {"Hindu", "Muslim", "Christian", "Sikh", "Jain", "Others"};
        religion = new JComboBox(valrel);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categorylabel = new JLabel("Category: ");
        categorylabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categorylabel.setBounds(100, 190, 200, 30);
        add(categorylabel);

        String valcat[] = {"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valcat);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String incomeval[] = {"Null", "<1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "Others"};
        incomebox = new JComboBox(incomeval);
        incomebox.setBounds(300, 240, 400, 30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        JLabel qualifications = new JLabel("Qualifications: ");
        qualifications.setFont(new Font("Raleway", Font.BOLD, 20));
        qualifications.setBounds(100, 315, 200, 30);
        add(qualifications);

        String eqval[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"};
        eqbox = new JComboBox(eqval);
        eqbox.setBounds(300, 315, 400, 30);
        eqbox.setBackground(Color.WHITE);
        add(eqbox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String occval[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occbox = new JComboBox(occval);
        occbox.setBounds(300, 390, 400, 30);
        occbox.setBackground(Color.WHITE);
        add(occbox);

        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel snrctzn = new JLabel("Senior Citizen: ");
        snrctzn.setFont(new Font("Raleway", Font.BOLD, 20));
        snrctzn.setBounds(100, 540, 200, 30);
        add(snrctzn);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        JLabel existing = new JLabel("Existing Account: ");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(eyes);
        accountgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String Rel = (String) religion.getSelectedItem();
        String Cat = (String) category.getSelectedItem();
        String Income = (String) incomebox.getSelectedItem();
        String Edu = (String) eqbox.getSelectedItem();
        String Occ = (String) occbox.getSelectedItem();
        String snr = null;
        if (syes.isSelected()) {
            snr = "Yes";
        } else if (sno.isSelected()) {
            snr = "No";
        }

        String existingacc = null;
        if (eyes.isSelected()) {
            existingacc = "Yes";
        } else if (eno.isSelected()) {
            existingacc = "No";
        }
        String pan = panTextField.getText();
        String aadharno = aadharTextField.getText();

        try {
            Connectivity c = new Connectivity();
            String query = "insert into signup2 values('" + formno + "','" + Rel + "','" + Cat + "','" + Income + "','" + Edu + "','" + Occ + "','" + pan + "','" + aadharno + "','" + existingacc + "','" + snr + "')";
            c.st.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

    }
}
