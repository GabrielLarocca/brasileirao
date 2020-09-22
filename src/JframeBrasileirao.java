
import java.util.Random;
import javax.swing.table.DefaultTableModel;

public class JframeBrasileirao extends javax.swing.JFrame {
            
            public class ClubeObj{

            public String clube[];;

            public Integer pontuacao;

            public Integer vitorias;

            public Integer derrotas;
            
            public Integer empates;


            }
	

	
   public static void tabela(String[] clube){
	for (int i=0; i<20; i++){;
            for(int j=0; j<20; j++){
                if (i!=j){
                    System.out.print(clube[i]);
                    System.out.print(" x ");
                    System.out.println(clube[j]);
                    }
                }
            }
    }
   
   public void gerarJogos(){
       int tamanhoLista = jList.getModel().getSize();
       DefaultTableModel tabela = new DefaultTableModel();
       for (int i = 0; i < tamanhoLista; i++){
           for(int j =0; j < tamanhoLista; j++){
               if(i != j){
                    Random aleatorio = new Random();
                    int random = aleatorio.nextInt((6 - 0) + 1) + 0;
                    int random1 = aleatorio.nextInt((6 - 0) + 1) + 0;

                    double valor1 = random;
                    double valor2 = random1;
                    
                    int placar1 = (int)valor1;
                    int placar2 = (int)valor2;
                    
          


                    
                    String col1 = jList.getModel().getElementAt(i);
                    String col2 = Integer.toString(placar1);
                    String col3 = " ";
                    String col4 = Integer.toString(placar2);
                    String col5 = jList.getModel().getElementAt(j);
                    
                    Object[] linha = {col1, col2, col3, col4, col5};

                   tabela = (DefaultTableModel)jTableLocal.getModel(); 
                   tabela.addRow(linha);
               }
           }
       } 
   }
   
   public void gerarPlacar(){
       
    
   }
   
   
   
   
   
    public JframeBrasileirao() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLocal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        gerarbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelajogos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Times:");

        jTableLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Local", "", "X", "", "Visitante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLocal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableLocal);
        if (jTableLocal.getColumnModel().getColumnCount() > 0) {
            jTableLocal.getColumnModel().getColumn(0).setResizable(false);
            jTableLocal.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTableLocal.getColumnModel().getColumn(1).setResizable(false);
            jTableLocal.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTableLocal.getColumnModel().getColumn(2).setResizable(false);
            jTableLocal.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTableLocal.getColumnModel().getColumn(3).setResizable(false);
            jTableLocal.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTableLocal.getColumnModel().getColumn(4).setResizable(false);
            jTableLocal.getColumnModel().getColumn(4).setPreferredWidth(45);
        }

        jButton1.setText("Salvar");

        gerarbtn.setText("Gerar");
        gerarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarbtnActionPerformed(evt);
            }
        });

        jButton3.setText("Limpar");

        tabelajogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIME", "P", "V", "E", "D", "GP", "GN", "SG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelajogos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelajogos);
        if (tabelajogos.getColumnModel().getColumnCount() > 0) {
            tabelajogos.getColumnModel().getColumn(0).setMinWidth(100);
            tabelajogos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelajogos.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelajogos.getColumnModel().getColumn(1).setResizable(false);
            tabelajogos.getColumnModel().getColumn(2).setResizable(false);
            tabelajogos.getColumnModel().getColumn(3).setResizable(false);
            tabelajogos.getColumnModel().getColumn(4).setResizable(false);
            tabelajogos.getColumnModel().getColumn(5).setResizable(false);
            tabelajogos.getColumnModel().getColumn(6).setResizable(false);
            tabelajogos.getColumnModel().getColumn(7).setResizable(false);
        }

        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = new String[] {
                "Athletico-PR", "Atletico-MG", "Atletico-GO", "Bahia", "Botafogo", "Bragantino", "Ceara", "Corinthians", "Coritiba", "Flamengo",
                "Fluminense", "Fortaleza", "Goias", "Gremio", "Internacional", "Palmeiras", "Santos", "São Paulo", "Sport", "Vasco" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(gerarbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gerarbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarbtnActionPerformed
        gerarJogos();
    }//GEN-LAST:event_gerarbtnActionPerformed

    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValueChanged
        int index = jList.getSelectedIndex();
    }//GEN-LAST:event_jListValueChanged

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeBrasileirao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerarbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableLocal;
    private javax.swing.JTable tabelajogos;
    // End of variables declaration//GEN-END:variables

}
