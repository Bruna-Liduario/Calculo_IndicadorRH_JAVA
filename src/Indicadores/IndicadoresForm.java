package Indicadores;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public abstract class IndicadoresForm extends JFrame {

    //Paineis
    protected JPanel pnlForm;
    protected JPanel pnlResultado;
    protected JPanel pnlBotoes;


    //Botão
    protected JButton btnCalcular;
    protected JButton btnLimpar;

    //Campos para preenchimento
    //QuantidadeFaltas
    protected JLabel lblQtdFaltas;
    protected JTextField txtQtdFaltas;

    //Total de Funcionários
    protected JLabel lblFuncionarios;
    protected JTextField txtFuncionarios;

    //Admitidos
    protected JLabel lblAdmitidos;
    protected JTextField txtAdmitidos;

    //Demitidos
    protected JLabel lblDemitidos;
    protected JTextField txtDemitidos;


    public IndicadoresForm(){
        this.inicializar();

    }

    private void inicializar(){
        this.setTitle("Indicadores Recursos Humanos");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());//Avisa como serão distribuidos os componentes do formulário
        this.getContentPane().add(getPnlBotoes(), BorderLayout.LINE_END);
        this.getContentPane().add(getPnlForm(), BorderLayout.LINE_START);
        this.getContentPane().add(getPnlResultado(), BorderLayout.PAGE_END);
        btnCalcular.addActionListener(e -> realizarCalculos());
            this.pack();
    }


    public JPanel getPnlForm () {
        if (pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4,2));

            lblQtdFaltas = new JLabel("Quantidade de Faltas");
            txtQtdFaltas = new JTextField("");

            lblFuncionarios = new JLabel("Total de Funcionários");
            txtFuncionarios = new JTextField("");

            lblAdmitidos = new JLabel("Admitidos");
            txtAdmitidos = new JTextField("");

            lblDemitidos = new JLabel("Demitidos");
            txtDemitidos = new JTextField("");

            pnlForm.add(lblQtdFaltas);
            pnlForm.add(txtQtdFaltas);
            pnlForm.add(lblFuncionarios);
            pnlForm.add(txtFuncionarios);
            pnlForm.add(lblAdmitidos);
            pnlForm.add(txtAdmitidos);
            pnlForm.add(lblDemitidos);
            pnlForm.add(txtDemitidos);

        }
            return pnlForm;
    }

    public JPanel getPnlBotoes() {
        if (pnlBotoes == null){
            pnlBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            btnCalcular = new JButton("Calcular");
            btnLimpar = new JButton("Limpar");

            pnlBotoes.add(btnCalcular);
            pnlBotoes.add(btnLimpar);
        }
        return pnlBotoes;
    }

    public JPanel getPnlResultado () {
        if (pnlResultado == null){
            pnlResultado = new JPanel();
        }
        return pnlResultado;
    }

    private void realizarCalculos(){
        //O método getText() retorna o conteúdo do campo de texto como uma string.
        //Integer.parseInt() para converter a string em um valor inteiro
        int faltas = Integer.parseInt(txtQtdFaltas.getText());
        int Funcionarios = Integer.parseInt(txtFuncionarios.getText());
        int admitidos = Integer.parseInt(txtAdmitidos.getText());
        int demitidos = Integer.parseInt(txtDemitidos.getText());

        double absenteismo = (double) faltas / Funcionarios * 100;
        double turnover = ((double) (admitidos + demitidos) / 2) / Funcionarios * 100;

        atualizarResultados(absenteismo, turnover); // Atualiza o painel de resultados

    }

    private void atualizarResultados(double absenteismo, double turnover) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // Formato para exibir com duas casas decimais
        String absenteismoFormatado = decimalFormat.format(absenteismo);
        String turnoverFormatado = decimalFormat.format(turnover);

        pnlResultado.removeAll();
        pnlResultado.add(new JLabel("Indicador de Absenteísmo: " + absenteismoFormatado + "%"));
        pnlResultado.add(new JLabel("Indicador de Turnover: " + turnoverFormatado + "%"));
        pnlResultado.revalidate();
        pnlResultado.repaint();
    }

}
