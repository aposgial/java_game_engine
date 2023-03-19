import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyExchangeApp extends JFrame implements ActionListener {
    // GUI components
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JButton exchangeButton;
    private JLabel resultLabel;

    // exchange rates (dummy data)
    private final double USD_TO_EUR_RATE = 0.85;
    private final double USD_TO_GBP_RATE = 0.73;
    private final double EUR_TO_USD_RATE = 1.18;
    private final double EUR_TO_GBP_RATE = 0.86;
    private final double GBP_TO_USD_RATE = 1.38;
    private final double GBP_TO_EUR_RATE = 1.16;

    public CurrencyExchangeApp() {
        // set up GUI components
        setTitle("Currency Exchange App");
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel amountLabel = new JLabel("Amount:");
        add(amountLabel);

        amountField = new JTextField();
        add(amountField);

        JLabel fromCurrencyLabel = new JLabel("From currency:");
        add(fromCurrencyLabel);

        String[] currencyOptions = {"USD", "EUR", "GBP"};
        fromCurrencyComboBox = new JComboBox<String>(currencyOptions);
        add(fromCurrencyComboBox);

        JLabel toCurrencyLabel = new JLabel("To currency:");
        add(toCurrencyLabel);

        toCurrencyComboBox = new JComboBox<String>(currencyOptions);
        add(toCurrencyComboBox);

        exchangeButton = new JButton("Exchange");
        exchangeButton.addActionListener(this);
        add(exchangeButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        // set window size and display
        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // perform currency exchange calculation
        String amountString = amountField.getText();
        double amount = Double.parseDouble(amountString);

        String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
        String toCurrency = (String) toCurrencyComboBox.getSelectedItem();

        double exchangeRate = 0.0;

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            exchangeRate = USD_TO_EUR_RATE;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            exchangeRate = USD_TO_GBP_RATE;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            exchangeRate = EUR_TO_USD_RATE;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            exchangeRate = EUR_TO_GBP_RATE;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            exchangeRate = GBP_TO_USD_RATE;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            exchangeRate = GBP_TO_EUR_RATE;
        }

        double result = amount * exchangeRate;

        // display result
        String resultString = String.format("%.2f %s = %.2f %s", amount, fromCurrency, result, toCurrency);
        resultLabel.setText(resultString);
    }

    public static void main(String args[]){
        CurrencyExchangeApp app = new CurrencyExchangeApp();
    }
}
