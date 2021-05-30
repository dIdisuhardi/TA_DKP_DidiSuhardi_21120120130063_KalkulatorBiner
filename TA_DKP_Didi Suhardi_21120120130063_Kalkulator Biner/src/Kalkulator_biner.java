import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator_biner {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textfield_desimal;
    private JTextField textField_biner;
    private JTextField textField_oktal;
    private JTextField textField_heksa;
    private JButton kali_button;
    private JButton hasil_button;
    private JButton bagi_button;
    private JButton tambah_button;
    private JButton kurang_button;
    private JButton clearButton;
    private JLabel desimal_field;
    private JLabel biner_field;
    private JLabel oktal_field;
    private JLabel heksa_field;
    private JComboBox pilihan_box;
    int bilpertama;
    int bilkedua;
    String nilai_inputan;
    String operasi;
    String input1;
    String input2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Biner");
        frame.setContentPane(new Kalkulator_biner().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Kalkulator_biner() {
        tambah_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1 = textField1.getText();
                Kalkulator_biner.this.milih_input();
                nilai_inputan = textField1.getText();
                bilpertama = Integer.parseInt(nilai_inputan);
                operasi = "+";
                textField1.setText("");
            }
        });
        kurang_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1 = textField1.getText();
                Kalkulator_biner.this.milih_input();
                nilai_inputan = textField1.getText();
                bilpertama = Integer.parseInt(nilai_inputan);
                operasi = "-";
                textField1.setText("");
            }
        });
        kali_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1 = textField1.getText();
                Kalkulator_biner.this.milih_input();
                nilai_inputan = textField1.getText();
                bilpertama = Integer.parseInt(nilai_inputan);;
                operasi = "x";
                textField1.setText("");
            }
        });
        bagi_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input1 = textField1.getText();
                Kalkulator_biner.this.milih_input();
                nilai_inputan = textField1.getText();
                bilpertama = Integer.parseInt(nilai_inputan);
                operasi = ":";
                textField1.setText("");
            }
        });
        hasil_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input2 = textField1.getText();
                Kalkulator_biner.this.milih_input();
                bilkedua = Integer.parseInt(textField1.getText());
                switch (operasi) {
                    case "+" -> {
                        int totalNum = bilpertama + bilkedua;
                        textField1.setText(String.valueOf(totalNum));
                    }
                    case "-" -> {
                        int totalNum = bilpertama - bilkedua;
                        textField1.setText(String.valueOf(totalNum));
                    }
                    case "x" -> {
                        int totalNum = bilpertama * bilkedua;
                        textField1.setText(String.valueOf(totalNum));
                    }
                    case ":" -> {
                        int totalNum = bilpertama / bilkedua;
                        textField1.setText(String.valueOf(totalNum));
                    }
                }
                Kalkulator_biner.this.konversi_hasil();
                Kalkulator_biner.this.milih_output();
                String akhir = input1 + " " + operasi + " " + input2 + " = " + textField1.getText();
                textField1.setText(akhir);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textfield_desimal.setText("");
                textField_biner.setText("");
                textField_heksa.setText("");
                textField_oktal.setText("");
            }
        });
    }

    public void inputan(final String jenis_input){
        final String angkaInput = this.textField1.getText();
        switch (jenis_input){
            case "Desimal":{
                break;
            }
            case "Biner":{
                final int y = Integer.parseInt(angkaInput, 2);
                final String angka_konveri = Integer.toString(y);
                this.textField1.setText(angka_konveri);
                break;
            }
            case "Oktal":{
                final int y = Integer.parseInt(angkaInput, 8);
                final String angka_konveri = Integer.toString(y);
                this.textField1.setText(angka_konveri);
                break;
            }
            case "Heksa":{
                final int y = Integer.parseInt(angkaInput, 16);
                final String angka_konveri = Integer.toString(y);
                this.textField1.setText(angka_konveri);
                break;
            }
        }
    }

    public void milih_input() {
        final String a = (String) this.pilihan_box.getSelectedItem();
        final String D = "Desimal";
        final String B = "Biner";
        final String O = "Oktal";
        final String H = "Heksadesimal";
        if (a.equals(D)) {
            this.inputan("Desimal");
        } else if (a.equals(B)) {
            this.inputan("Biner");
        } else if (a.equals(O)) {
            this.inputan("Oktal");
        } else if (a.equals(H)) {
            this.inputan("Heksa");
        }
    }
    public void outputan(final String con) {
        final String numInput = this.textField1.getText();
        final int n = Integer.parseInt(numInput);
        switch (con) {
            case "Biner": {
                final String binary = Integer.toBinaryString(n);
                this.textField1.setText(binary);
                break;
            }
            case "Oktal": {
                final String binary = Integer.toOctalString(n);
                this.textField1.setText(binary);
                break;
            }
            case "Heksa": {
                final String binary = Integer.toHexString(n);
                this.textField1.setText(binary);
                break;
            }
            case "Desimal": {
                final String binary = Integer.toString(n);
                this.textField1.setText(binary);
                break;
            }
        }
    }

    public void milih_output() {
        final String a = (String) this.pilihan_box.getSelectedItem();
        final String D = "Desimal";
        final String B = "Biner";
        final String O = "Oktal";
        final String H = "Heksadesimal";
        if (a.equals(D)) {
            this.outputan("Desimal");
        } else if (a.equals(B)) {
            this.outputan("Biner");
        } else if (a.equals(O)) {
            this.outputan("Oktal");
        } else if (a.equals(H)) {
            this.outputan("Heksa");
        }
    }

    public void konversi_hasil(){
        final String a = textField1.getText();
        int x = Integer.parseInt(a);
        final String biner = Integer.toBinaryString(x);
        final String oktal = Integer.toOctalString(x);
        final String heksa = Integer.toHexString(x);
        final String desimal = Integer.toString(x);
        textfield_desimal.setText(desimal);
        textField_biner.setText(biner);
        textField_oktal.setText(oktal);
        textField_heksa.setText(heksa);
    }
}