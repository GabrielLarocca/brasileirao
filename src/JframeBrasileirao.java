import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import java.util.Random;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;


public class JframeBrasileirao extends javax.swing.JFrame {
    
        //array de strings com o nome dos times
        String[] times = {"Athletico-PR","Atlético-GO","Atlético-MG","Bahia","Botafogo","Bragantino","Ceará","Corinthians","Coritiba","Flamengo","Fluminense","Fortaleza","Goiás","Grêmio",
        "Internacional","Palmeiras","Santos","São Paulo","Sport","Vasco"};

        //cria header da tabela de resultados
        DefaultTableModel tabelaRes = new DefaultTableModel(new Object[0][], new String[]{"Local","","   X   ","","Visitante"});
        
        //cria header da tabela final
        DefaultTableModel tabelaFim = new DefaultTableModel(new Object[0][], new String[]{"Time","P","V","E","D","GP","GN","SG"});
        
   
   public void gerarJogos(){
       //pega o tamanho da lista de time (o numero de times na tabela)
       int tamanhoLista = jList.getModel().getSize();
       DefaultTableModel tabela = new DefaultTableModel();
       
       //roda a primeira coluna de times na tabela 
       for (int i = 0; i < tamanhoLista; i++){
           //roda a segunda coluna de times na tabela 
           for(int j =0; j < tamanhoLista; j++){
               //se forem times diferentes roda o jogo, caso contrario o jogo nao existe
               if(i != j){                 
                   //declaração dos resultados de maneira aleatoria
                    Random aleatorio = new Random();
                    int random = aleatorio.nextInt((6 - 0) + 1) + 0;
                    int random1 = aleatorio.nextInt((6 - 0) + 1) + 0;
                    double valor1 = random;
                    double valor2 = random1;
                    
                    //cada placar recebe um numero aleatorio
                    int placar1 = (int)valor1;
                    int placar2 = (int)valor2;
                    
                    //coleta o nome do primeiro time
                    String col1 = jList.getModel().getElementAt(i);
                    //mostra primeiro placar
                    String col2 = Integer.toString(placar1);
                    //coluna com espaço em branco
                    String col3 = " ";
                    //mostra segundo placar
                    String col4 = Integer.toString(placar2);
                    //coleta o nome do segundo time
                    String col5 = jList.getModel().getElementAt(j);
                    
                    //declara objeto com as colunas acima
                    Object[] linha = {col1, col2, col3, col4, col5};

                    //variavel que recebe a tabela
                   tabela = (DefaultTableModel)tabelagames.getModel(); 
                   //adiciona o objeto como as linhas
                   tabela.addRow(linha);
               }
           }
       } 
   }
   
   
    private void gerarJogosa(){
        //pega objeto dos times
        TabelaTimes TimesObj[]=new TabelaTimes[times.length];
        //nova tabela com o tamanho do array de times
        for(int k=0;k<times.length;k++){
            TimesObj[k]=new TabelaTimes(times[k]);
        }

        //gera random number
        Random random = new Random();

        //gera primeiro array de times
        for(int i=0;i<times.length;i++){
           //ger segundo array de times
            for(int k=0;k<times.length;k++){
                //se os times forem os mesmos, não ha como ter jogo
                if(times[i].equals(times[k])){
                    continue;
                }
                //gera randons com range até 6
                int numUm=random.nextInt(6);
                int numDois=random.nextInt(6);
                
                //lista de jogos e adição em suas respectivas linhas
                Object[] jogos = {times[i],numUm,"X",numDois,times[k]};
                tabelaRes.addRow(jogos);
                
                //jogo numeros aleatorios como gol de cada time
                TimesObj[i].addGols(numUm, 0);
                TimesObj[i].addGols(numDois, 1);
                TimesObj[k].addGols(numUm, 1);
                TimesObj[k].addGols(numDois, 0);
                
                //verificação de qunatos pontos o time fez
                if(numUm>numDois){
                    TimesObj[i].addUm(1);
                    TimesObj[i].addPontos(10);
                    TimesObj[k].addUm(-1);
                }else if(numUm==numDois){
                    TimesObj[i].addUm(0);
                    TimesObj[i].addPontos(0);
                    TimesObj[k].addPontos(0);
                    TimesObj[k].addUm(0);
                }else{
                    TimesObj[i].addUm(-1);
                    TimesObj[k].addUm(1);
                    TimesObj[k].addPontos(10);
                }
            }
        }
        //adiciona todos os dados na tabela, por linha
        for(int k=0;k<times.length;k++){
            tabelaFim.addRow((Object[]) TimesObj[k].geta());
        }
    }
   
  public class TabelaTimes{
      //declaração itens da classe
        String nome;
        int pontos=0;
        int win=0;
        int draw=0;
        int lose=0;
        int golIn=0;
        int golOut=0;
        
        public TabelaTimes(String nome){
            //retorna a string do nome do time
            this.nome=nome;
        }
        
        //calc saldo de gols (feitos - sofridos)
        public int getGolSaldo(){return (golIn)-(golOut);}
        
        public Object geta(){
            //obj com todos os dados do time
            Object[] saldoDeTudo = {nome,pontos,win,draw,lose,golIn,golOut,getGolSaldo()};
            return saldoDeTudo;
        }
        
        //função que verifica o saldo de gols e adiciona os pontos
        public void addPontos(int signal){
            if(signal==0){
                pontos++;
            }else{
                pontos=pontos+3;
            }
        }
        
        //função que verifica se foi vitoria derrota ou empate
        public void addUm(int signal){
            if(signal==1){win++;}
            else if(signal==0){draw++;}
            else if(signal==-1){lose++;}
        }
        
        //função que adiciona gols ao placar
        public void addGols(int gols,int signal){
            if(signal==0){
                golIn+=gols;
            }else if(signal==1){
                golOut+=gols;
            }
        }
        
    }
  
    public JframeBrasileirao() {
        //inicia os componentes
        initComponents();
        btnLimpar.setEnabled(false);
        btnSalvar.setEnabled(false);
        tabelagames.setEnabled(false);
        jtabRes.setEnabled(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelagames = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnGerar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtabRes = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Times:");

        tabelagames.setModel(tabelaRes);
        tabelagames.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelagames);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnGerar.setText("Gerar");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jtabRes.setModel(tabelaFim);
        jtabRes.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtabRes);

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
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        //roda função para gerar jogos random
        gerarJogosa();
        
        //seta botoes limpar e salvar para true
        btnGerar.setEnabled(false);
        btnLimpar.setEnabled(true);
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnGerarActionPerformed

    private void jListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListValueChanged

    }//GEN-LAST:event_jListValueChanged

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //Limpa as linhas
        tabelaFim.setRowCount(0);
        tabelaRes.setRowCount(0);
        
        //Seta os botões para o inicial
        btnGerar.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnLimpar.setEnabled(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
      //função salvar resultados
       JFileChooser jf = new JFileChooser();
       jf.setDialogTitle("SALVAR");
       int response = jf.showSaveDialog(this);
       if(response == jf.APPROVE_OPTION){
           File selectedFile = jf.getSelectedFile();
           String path  = selectedFile.getAbsolutePath();
           try {
               FileWriter arq = new FileWriter(path+".txt");
               PrintWriter gravarArq = new PrintWriter(arq);
               //vai pegar todas as linhas da tabela de resultados
               for(int ii=0;ii<tabelaFim.getRowCount();ii++){
                   gravarArq.printf((String)jtabRes.getValueAt(ii,0)+ 
                           " / Pontos:" + jtabRes.getValueAt(ii,1)+
                           " / Vitorias:" + jtabRes.getValueAt(ii,2)+
                           " / Empate:" +jtabRes.getValueAt(ii,3)+
                           " / Derrotas:" +jtabRes.getValueAt(ii,4)+
                           " / Gols Feitos:" +jtabRes.getValueAt(ii,5)+
                           " / Gols Sofridos:" +jtabRes.getValueAt(ii,6)+
                           " / Saldo de Gols:" +jtabRes.getValueAt(ii,7)+"%n");
               }
               arq.close();
           } catch (IOException ex) {
               System.out.println("Ocorreu um erro");
               
           }   
       }
        
        btnGerar.setEnabled(false);
    }//GEN-LAST:event_btnSalvarActionPerformed

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeBrasileirao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtabRes;
    private javax.swing.JTable tabelagames;
    // End of variables declaration//GEN-END:variables

}
