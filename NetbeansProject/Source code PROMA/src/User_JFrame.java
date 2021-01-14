

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * User_JFrame.java
 *
 * Created on Jan 3, 2012, 4:07:01 PM
 */
/**
 *
 * @author 9589693153
 */
import com.itextpdf.text.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.MessageFormat;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;


public class User_JFrame extends javax.swing.JFrame {
Connection conn=null;
ResultSet rs = null;
PreparedStatement pst=null;

public void close1() {
WindowEvent winClosingEvent = new WindowEvent( this, WindowEvent.WINDOW_CLOSING );
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
}
 public void Update_doc_table(){
        
                   try{
               String sql="SELECT idnew_table,Attach_path ,Notes FROM Document_table  ORDER BY idnew_table  ";

    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
   table_document.setModel(DbUtils.resultSetToTableModel(rs));
   
    
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    } finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      } 
        
        
        
        }
        public void report(){
        
                 Calendar cal = new GregorianCalendar();
  int month = cal.get(Calendar.MONTH);
  int year = cal.get(Calendar.YEAR);
  int day = cal.get(Calendar.DAY_OF_MONTH);
  Lbl_Date.setText("                                                                      Date : "   + day + "/" + (month + 1) + "/" + year);
  System.out.println("Current date : " 
  + day + "/" + (month + 1) + "/" + year);
         String Comment=textArea1.getText();
        Availability();
        
        String Ava_pr1 = Double.toString(divide_pr1);
         String Ava_pr2 = Double.toString(divide_pr1);
         String Ava_pr3 = Double.toString(divide_pr1);
         String Ava_volumeflow = Double.toString(divide_volumeflow);
          String Ava_Temperature = Double.toString(divide_Temperature);
         String Ava_rotationalspeed = Double.toString(divide_rotationalspeed);
          String Ava_torque = Double.toString(divide_torque);
          String Ava_total = Double.toString(total_availability); 
          
             String txt_pressure1=txt_pressure1_max.getText();  
          String txt_pressure2=txt_pressure2_max.getText();  
          String txt_pressure3=txt_pressure3_max.getText();  
          String txt_vol_flow=txt_vol_flow_max.getText();  
          String txt_temp=txt_temp_max.getText();  
          String txt_rot_speed=txt_rot_speed_max.getText();  
          String txt_torque=txt_torque_max.getText();  
          
          String txt_pressure1_mi=txt_pressure1_min.getText();  
          String txt_pressure2_mi=txt_pressure2_min.getText();  
          String txt_pressure3_mi=txt_pressure3_min.getText();  
          String txt_vol_flow_mi=txt_vol_flow_min.getText();  
          String txt_temp_mi=txt_temp_min.getText();  
          String txt_rot_speed_mi=txt_rot_speed_min.getText();  
          String txt_torque_mi=txt_torque_min.getText();  
          
          String txt_pressure1_av=txt_pressure1_avg.getText();  
          String txt_pressure2_av=txt_pressure2_avg.getText();  
          String txt_pressure3_av=txt_pressure3_avg.getText();  
          String txt_vol_flow_av=txt_vol_flow_avg.getText();  
          String txt_temp_av=txt_temp_avg.getText();  
          String txt_rot_speed_av=txt_rot_speed_avg.getText();  
          String txt_torque_av=txt_torque_avg.getText();  
           
         
         
        
           try                                      //try statement
               
               
     {   
           
           Document document=new Document();
PdfWriter.getInstance(document,new FileOutputStream("PROMA REPORT.pdf"));

document.open();
document.addSubject("hhhhhhhhhhhh");     
   document.addHeader(date1,"hhii"); 
   document.addCreationDate();
 Image image1 = Image.getInstance("sanvysymbol.png");
 //  image1.scaleAbsolute(300,300);
document.add(image1);
 document.add(new Paragraph((new Chunk("SANVY  Solutions                                         "   + day + "/" + (month + 1) + "/" + year, FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD)))));
 document.add(new Paragraph("ProactiveMaintenance Management Assistance System (ProMA)"));
 document.add(new Paragraph("*************************************************************************************************"));
PdfPTable table=new PdfPTable(2);
PdfPCell cell = new PdfPCell (new Paragraph ("PROMA REPORT"));
cell.setColspan (8);
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor(BaseColor.GREEN);
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("PARAMETER"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell.setPadding (10.0f);
table.addCell (cell);
cell = new PdfPCell (new Paragraph ("AVAILABILITY (%)"));
cell.setHorizontalAlignment (Element.ALIGN_CENTER);
cell.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell.setPadding (10.0f);
table.addCell (cell);
table.addCell("Pressure 1");
table.addCell(Ava_pr1);
table.addCell("Pressure 2");
table.addCell(Ava_pr2);
table.addCell("Pressure 3");
table.addCell(Ava_pr3);
table.addCell("VolumeFlow");
table.addCell(Ava_volumeflow);
table.addCell("Temperature");
table.addCell(Ava_Temperature);
table.addCell("RotationalSpeed");
table.addCell(Ava_rotationalspeed);
table.addCell("Torque");
table.addCell(Ava_torque);
table.addCell("Total");
cell.setBackgroundColor(BaseColor.LIGHT_GRAY);


table.addCell(Ava_total);
cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
document.add(table);
//new table


PdfPTable table1=new PdfPTable(4);
PdfPCell cell1 = new PdfPCell (new Paragraph ("PROMA MIN-MAX-AVG REPORT"));
cell1.setColspan (8);
cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
cell1.setBackgroundColor(BaseColor.GREEN);
cell1.setPadding (10.0f);
table1.addCell (cell1);
cell1 = new PdfPCell (new Paragraph ("PARAMETER"));
cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
cell1.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell1.setPadding (10.0f);
table1.addCell (cell1);
cell1 = new PdfPCell (new Paragraph ("MAX"));
cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
cell1.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell1.setPadding (10.0f);
table1.addCell (cell1);
cell1 = new PdfPCell (new Paragraph ("MIN"));
cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
cell1.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell1.setPadding (10.0f);
table1.addCell (cell1);
cell1 = new PdfPCell (new Paragraph ("AVG"));
cell1.setHorizontalAlignment (Element.ALIGN_CENTER);
cell1.setBackgroundColor (BaseColor.LIGHT_GRAY);
cell1.setPadding (10.0f);
table1.addCell (cell1);


table1.addCell("Pressure 1");
table1.addCell(txt_pressure1);
table1.addCell(txt_pressure1_mi);
table1.addCell(txt_pressure1_av);
table1.addCell("Pressure 2");
table1.addCell(txt_pressure2);
table1.addCell(txt_pressure2_mi);
table1.addCell(txt_pressure2_av);
table1.addCell("Pressure 3");
table1.addCell(txt_pressure3);
table1.addCell(txt_pressure3_mi);
table1.addCell(txt_pressure3_av);

table1.addCell("VolumeFlow");
table1.addCell(txt_vol_flow);
table1.addCell(txt_vol_flow_mi);
table1.addCell(txt_vol_flow_av);
table1.addCell("Temperature");
table1.addCell(txt_temp);
table1.addCell(txt_temp_mi);
table1.addCell(txt_temp_av);
table1.addCell("RotationalSpeed");
table1.addCell(txt_rot_speed);
table1.addCell(txt_rot_speed_mi);
table1.addCell(txt_rot_speed_av);
table1.addCell("Torque");
table1.addCell(txt_torque);
table1.addCell(txt_torque_mi);
table1.addCell(txt_torque_av);


document.add(table1);

        document.add(new Paragraph("1.General comment    :"+Comment));
        document.add(new Paragraph("2.Possible actions   :"+possibleaction));
        
    document.add(new Paragraph(""));   
document.add(new Paragraph("© 2011-2012 Sanvy Solutions. All right reserved."));
  



      //  document.add(new Paragraph(new Date().toString()));
       
document.close(); 
     JOptionPane.showMessageDialog(null, "Report Saved");
     
     } catch (Exception e)                    //catch any exceptions here
       {
            JOptionPane.showMessageDialog(null,e);  //print the error
       }
        
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }   
        
        }
public void CurrentDate(){
    
    try{
         
        String sql=" SELECT min(date),max(date) FROM pump ";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
            date1=rs.getString("min(date)");
             date2=rs.getString("max(date)");
             
             Date datee1,datee2;
             datee1=Date.valueOf(date1);
             datee2=Date.valueOf(date2);
             jDateChooser_start_date.setDate(datee1);
             jDateChooser_end_date.setDate(datee2);
             System.out.println(date1);
             System.out.println(date2);
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      } 
    if(Combo_parameter==Combo_parameter.getItemAt(2))
            
            {
    jDateChooser_start_date.setBackground(Color.red);
    }
  
  Calendar cal = new GregorianCalendar();
  int month = cal.get(Calendar.MONTH);
  int year = cal.get(Calendar.YEAR);
  int day = cal.get(Calendar.DAY_OF_MONTH);
  Lbl_Date.setText("                                                                      Date : "   + day + "/" + (month + 1) + "/" + year);
  System.out.println("Current date : " 
  + day + "/" + (month + 1) + "/" + year);
  }

private void Availability(){
   //  double divide_torque=0,divide_rotationalspeed=0,divide_Temperature=0,divide_volumeflow=0,divide_pr1=0,divide_pr2=0,divide_pr3=0;

try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT Pressure1 FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"'";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    

         while(rs.next()){
             double pressure11 = rs.getDouble("pressure1");
             //System.out.println(pressure11);
             
             if(pressure11<=10.0 && pressure11>=0.0){
      
         counter1++;
        }
        if(pressure11 <=11.0 && pressure11>10.0){
        
       counter2++;
        }
        if(pressure11 > 11.0){
       
       counter3++;
        }
        
        
         double  avail_pr1 = (counter1 + counter2);
          divide_pr1 = (counter1 + counter2 + counter3 );
         divide_pr1 =( avail_pr1/divide_pr1 ) * 100;
         
    }
         
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
 try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT Pressure2 FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
  
         while(rs.next()){
             double pressure22 = rs.getDouble("pressure2");
             //System.out.println(pressure22);
             
             if(pressure22<=10.0 && pressure22>=0.0){
      
         counter1++;
        }
        if(pressure22 <=11.0 && pressure22>10.0){
        
       counter2++;
        }
        if(pressure22 > 11.0){
       
       counter3++;
        }
        
    }
         
        
         
         double  avail = (counter1 + counter2);
          divide_pr2 = (counter1 + counter2 + counter3 );
         divide_pr2 =( avail/divide_pr2 ) * 100;
        
                
            }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
        finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
  try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT Pressure3 FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"'";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
         while(rs.next()){
             double pressure33 = rs.getDouble("pressure3");
             //System.out.println(pressure33);
             
             if(pressure33<=500 && pressure33>=0){
      
         counter1++;
        }
        if(pressure33 >=501 && pressure33<=525){
        
       counter2++;
        }
        if(pressure33>525){
       
       counter3++;
        }
        
    }
         
      
         double  avail = (counter1 + counter2);
          divide_pr3 = (counter1 + counter2 + counter3 );
         divide_pr3 =( avail/divide_pr3 ) * 100;
         
             }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
        try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT VolumeFlow FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
  
         while(rs.next()){
             double volumeflow = rs.getDouble("VolumeFlow");
             //System.out.println(volumeflow);
             
         if(volumeflow<=500 && volumeflow>=0){
      
         counter1++;
        }
        if(volumeflow >=501 && volumeflow>=525){
        
       counter2++;
        }
        if(volumeflow>525){
       
       counter3++;
        }
  
        
    }
         
        
         double  avail = (counter1 + counter2);
        divide_volumeflow = (counter1 + counter2 + counter3 );
         divide_volumeflow =( avail/divide_volumeflow ) * 100;
         int hello=(int)divide_volumeflow;
     
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
            finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT Temperature FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
  
         while(rs.next()){
             double Temperature1 = rs.getDouble("Temperature");
             //System.out.println(Temperature1);
             
         if(Temperature1<=60 && Temperature1>=0){
      
         counter1++;
        }
        if(Temperature1 <=0 && Temperature1>=-3  ||  (Temperature1 >=60 && Temperature1<=63)){
        
       counter2++;
        }
        if(Temperature1>63){
       
       counter3++;
        }
        
      
        
        
        
        
    }
         
     
         double  avail = (counter1 + counter2);
       divide_Temperature = (counter1 + counter2 + counter3 );
         divide_Temperature  =( avail/divide_Temperature  ) * 100;
         int hello=(int)divide_Temperature ;
        
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
            finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
 try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT RotationalSpeed FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
         while(rs.next()){
             double rotationalspeed1 = rs.getDouble("RotationalSpeed");
             //System.out.println(rotationalspeed1);
             
         if(rotationalspeed1<=6000){
      
         counter1++;
        }
        if(rotationalspeed1  <=6120 && rotationalspeed1>=6001 ){
        
       counter2++;
        }
        if(rotationalspeed1>6120){
       
       counter3++;
        }
        
       
        
        
        
    }
         double  avail = (counter1 + counter2);
         divide_rotationalspeed = (counter1 + counter2 + counter3 );
         divide_rotationalspeed =( avail/divide_rotationalspeed ) * 100;
         int hello=(int)divide_rotationalspeed;
         
         
         
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
            finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT Torque FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    

         while(rs.next()){
             double torque1 = rs.getDouble("Torque");
            // System.out.println(torque1);
             
         if(torque1 <=200 && torque1>=0){
      
         counter1++;
        }
        if(torque1  <=210 && torque1>=201){
        
       counter2++;
        }
        if(torque1>210){
       
       counter3++;
        }
    
        
    }
     
         double  avail = (counter1 + counter2);
          divide_torque = (counter1 + counter2 + counter3 );
         divide_torque =( avail/divide_torque ) * 100;
         int hello=(int)divide_torque;
      
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
            finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
     double sum_availability  =divide_torque+divide_rotationalspeed+divide_Temperature+divide_volumeflow+divide_pr1+divide_pr2+divide_pr3;
      total_availability =(sum_availability/7);  
       int availability_total=(int)total_availability;
         jProgressBar_availability_total.setValue(availability_total);
         String avail1 = Double.toString(total_availability);
         
           float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability_total.setText(avail11);
         
        // txt_availability_total.setText(avail11);

}
private void UpdateJTable(){
         String sql="Select  idpump,Date,Pressure1,Pressure2,Pressure3,VolumeFlow,Temperature,RotationalSpeed,Torque,Availability   from pump ";
     
  try{
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));
   
    
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
}
public void GetMinMax(){

    
                            try{
                String sql="SELECT MAX(pressure1) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(pressure1)");
   txt_pressure1_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                    
   try{
                String sql="SELECT MIN(pressure1) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(pressure1)");
    txt_pressure1_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
   try{
                String sql="SELECT AVG(pressure1) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(pressure1)");
    
    float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_pressure1_avg.setText(avail1);
   // float hello=(float)divide1;
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  

                     try{
                String sql="SELECT MAX(pressure2) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(pressure2)");
    txt_pressure2_max.setText(add1);
    // System.out.printf("Value: %.2f", divide1)
             
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
               finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                   
   try{
                String sql="SELECT MIN(pressure2) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(pressure2)");
    txt_pressure2_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
   try{
                String sql="SELECT AVG(pressure2) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(pressure2)");
    
    float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_pressure2_avg.setText(avail1);
   
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }

          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
   
                   try{
                String sql="SELECT MAX(pressure3) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(pressure3)");
    txt_pressure3_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
             finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                     
   try{
                String sql="SELECT MIN(pressure3) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(pressure3)");
    txt_pressure3_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
    try{
                String sql="SELECT AVG(pressure3) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(pressure3)");
     
    float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_pressure3_avg.setText(avail1);
   // txt_pressure3_avg.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
            try{
                String sql="SELECT MAX(volumeflow) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(volumeflow)");
    txt_vol_flow_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
               finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                   
   try{
                String sql="SELECT MIN(volumeflow) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(volumeflow)");
    txt_vol_flow_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
   try{
                String sql="SELECT AVG(volumeflow) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(volumeflow)");
     
    float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
           txt_vol_flow_avg.setText(avail1);
  //  txt_vol_flow_avg.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
   
   
          finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
           try{
                String sql="SELECT MAX(temperature) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(temperature)");
    txt_temp_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
                 finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                 
   try{
                String sql="SELECT MIN(temperature) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(temperature)");
    txt_temp_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
     try{
                String sql="SELECT AVG(temperature) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(temperature)");
     float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_temp_avg.setText(avail1);
   // txt_temp_avg.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
   
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
                String sql="SELECT MAX(rotationalspeed) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(rotationalspeed)");
    txt_rot_speed_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
                finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                  
   try{
                String sql="SELECT MIN(rotationalspeed) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(rotationalspeed)");
    txt_rot_speed_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
     try{
                String sql="SELECT avg(rotationalspeed) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(rotationalspeed)");
    float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_rot_speed_avg.setText(avail1);
    //txt_rot_speed_avg.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
   
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
                String sql="SELECT MAX(torque) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MAX(torque)");
    txt_torque_max.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
               finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                   
   try{
                String sql="SELECT MIN(torque) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("MIN(torque)");
    txt_torque_min.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
   finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
   try{
                String sql="SELECT AVG(torque) FROM pump ";
               
           pst =conn.prepareStatement(sql);
           rs=pst.executeQuery();
  
    if(rs.next()){
    String add1=rs.getString("AVG(torque)");
     float x = Float.parseFloat(add1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail1 = Float.toString(x);
          txt_torque_avg.setText(avail1);
   // txt_torque_avg.setText(add1);
    }        
    }
           catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
}
    /** Creates new form User_JFrame */
    public User_JFrame() {
        initComponents();
        conn=ConnectionPROMA .ConnecrDb();
        UpdateJTable();
        GetMinMax();
        CurrentDate();
       
        Update_doc_table();
        
    }

    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        cmd_report1 = new javax.swing.JButton();
        cmd_chart1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cmd_data1 = new javax.swing.JButton();
        cmd_ok1 = new javax.swing.JButton();
        cmd_close1 = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        cmd_SignOut = new javax.swing.JButton();
        Lbl_Date = new javax.swing.JLabel();
        jPanel_Pumpdata = new javax.swing.JPanel();
        Label_pumpid = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel_pr1 = new javax.swing.JLabel();
        jLabel_pr2 = new javax.swing.JLabel();
        jLabel_pr3 = new javax.swing.JLabel();
        jLabel_volumeflow = new javax.swing.JLabel();
        jLabel_temperature = new javax.swing.JLabel();
        jLabel_rotationalspeed = new javax.swing.JLabel();
        jLabel_torque = new javax.swing.JLabel();
        txt_pumpid = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        txt_pr1 = new javax.swing.JTextField();
        txt_pr2 = new javax.swing.JTextField();
        txt_pr3 = new javax.swing.JTextField();
        txt_volumeflow = new javax.swing.JTextField();
        txt_temperature = new javax.swing.JTextField();
        txt_rotationalspeed = new javax.swing.JTextField();
        txt_torque = new javax.swing.JTextField();
        cmd_savenewdata = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextField_torque = new javax.swing.JTextField();
        jTextField_rotspeed = new javax.swing.JTextField();
        jTextField_temp = new javax.swing.JTextField();
        jTextField_volFlow = new javax.swing.JTextField();
        jTextField_pr3 = new javax.swing.JTextField();
        jTextField_pr2 = new javax.swing.JTextField();
        jTextField_pr1 = new javax.swing.JTextField();
        jSlider1_pressure1 = new javax.swing.JSlider();
        jSlider2_pressure2 = new javax.swing.JSlider();
        jSlider3_pressure3 = new javax.swing.JSlider();
        jSlider4_vol_flow = new javax.swing.JSlider();
        jSlider5_temperature = new javax.swing.JSlider();
        jSlider6_rot_speed = new javax.swing.JSlider();
        jSlider7_torque = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        jLabel5_redlight = new javax.swing.JTextField();
        jLabel6_orangelight = new javax.swing.JTextField();
        jLabel7_greenlight = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Combo_parameter = new javax.swing.JComboBox();
        txt_startValue = new javax.swing.JTextField();
        txt_endValue = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        txt_availability_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jProgressBar_availability_total = new javax.swing.JProgressBar();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser_start_date = new com.toedter.calendar.JDateChooser();
        jDateChooser_end_date = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_pressure1_max = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_pressure2_max = new javax.swing.JTextField();
        txt_pressure3_max = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_vol_flow_max = new javax.swing.JTextField();
        txt_temp_max = new javax.swing.JTextField();
        txt_rot_speed_max = new javax.swing.JTextField();
        txt_pressure1_min = new javax.swing.JTextField();
        txt_pressure2_min = new javax.swing.JTextField();
        txt_pressure3_min = new javax.swing.JTextField();
        txt_vol_flow_min = new javax.swing.JTextField();
        txt_temp_min = new javax.swing.JTextField();
        txt_rot_speed_min = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_torque_min = new javax.swing.JTextField();
        txt_torque_max = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_vol_flow_avg = new javax.swing.JTextField();
        txt_pressure3_avg = new javax.swing.JTextField();
        txt_pressure2_avg = new javax.swing.JTextField();
        txt_torque_avg = new javax.swing.JTextField();
        txt_temp_avg = new javax.swing.JTextField();
        txt_rot_speed_avg = new javax.swing.JTextField();
        txt_pressure1_avg = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel_no_red = new javax.swing.JLabel();
        jLabel_no_orange = new javax.swing.JLabel();
        jLabel_no_green = new javax.swing.JLabel();
        jLabel_field = new javax.swing.JLabel();
        traffic_green = new javax.swing.JLabel();
        traffic_orange = new javax.swing.JLabel();
        traffic_red = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txt_availability = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jProgressBar_availability = new javax.swing.JProgressBar();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Remarks_oneday_ok = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        textArea1 = new java.awt.TextArea();
        jPanel9 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txt_document = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_notes = new javax.swing.JTextField();
        cmd_attach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_document = new javax.swing.JTable();
        cmd_save_doc = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txt_docid = new javax.swing.JTextField();
        cmd_delete_doc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_pumpdata = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        cmd_report = new javax.swing.JButton();
        cmd_close = new javax.swing.JButton();
        cmd_chart = new javax.swing.JButton();
        cmd_data = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmd_ok = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_aboutus = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ProMA A");

        jToolBar1.setBackground(new java.awt.Color(153, 255, 204));
        jToolBar1.setRollover(true);

        cmd_report1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_report1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports-icon.png"))); // NOI18N
        cmd_report1.setText("Report");
        cmd_report1.setFocusable(false);
        cmd_report1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_report1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_report1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_report1ActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_report1);

        cmd_chart1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_chart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chart-icon.png"))); // NOI18N
        cmd_chart1.setText("Chart");
        cmd_chart1.setFocusable(false);
        cmd_chart1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_chart1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_chart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_chart1ActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_chart1);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-edit-clear-icon (1).png"))); // NOI18N
        jButton7.setText("Clear");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        cmd_data1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_data1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/basic-data-icon.png"))); // NOI18N
        cmd_data1.setText("Report Pdf");
        cmd_data1.setFocusable(false);
        cmd_data1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_data1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_data1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_data1ActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_data1);

        cmd_ok1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_ok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ok-icon.png"))); // NOI18N
        cmd_ok1.setText("OK");
        cmd_ok1.setFocusable(false);
        cmd_ok1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_ok1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_ok1ActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_ok1);

        cmd_close1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_close1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Close-icon.png"))); // NOI18N
        cmd_close1.setText("Close");
        cmd_close1.setFocusable(false);
        cmd_close1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_close1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_close1ActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_close1);

        cmd_print.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print-icon.png"))); // NOI18N
        cmd_print.setText("Print");
        cmd_print.setFocusable(false);
        cmd_print.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_print.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_print);

        cmd_SignOut.setBackground(new java.awt.Color(255, 153, 153));
        cmd_SignOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cmd_SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SignOut-icon (1).png"))); // NOI18N
        cmd_SignOut.setText("Sign Out");
        cmd_SignOut.setFocusable(false);
        cmd_SignOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmd_SignOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cmd_SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_SignOutActionPerformed(evt);
            }
        });
        jToolBar1.add(cmd_SignOut);

        Lbl_Date.setFont(new java.awt.Font("Script MT Bold", 1, 18)); // NOI18N
        Lbl_Date.setForeground(new java.awt.Color(0, 51, 51));
        Lbl_Date.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar-icon.png"))); // NOI18N
        Lbl_Date.setText(" Date");
        jToolBar1.add(Lbl_Date);

        jPanel_Pumpdata.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pump Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        Label_pumpid.setText("Pump Id ");

        jLabel_date.setText("Date");

        jLabel_pr1.setText("Pressure 1 (Bar)");

        jLabel_pr2.setText("Pressure 2 (Bar)");

        jLabel_pr3.setText("Pressure 3 (Bar)");

        jLabel_volumeflow.setText("Volume Flow(m³/h)");

        jLabel_temperature.setText("Temperature (°C)");

        jLabel_rotationalspeed.setText("Rotational Speed");

        jLabel_torque.setText("Torque  (Nm)");

        txt_torque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_torqueActionPerformed(evt);
            }
        });

        cmd_savenewdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-document-save-all-icon.png"))); // NOI18N
        cmd_savenewdata.setText("Save New Data");
        cmd_savenewdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_savenewdataActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin-2-icon.png"))); // NOI18N
        jButton10.setText("Delete Data      ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_PumpdataLayout = new javax.swing.GroupLayout(jPanel_Pumpdata);
        jPanel_Pumpdata.setLayout(jPanel_PumpdataLayout);
        jPanel_PumpdataLayout.setHorizontalGroup(
            jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                        .addComponent(jLabel_torque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_torque, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                        .addComponent(jLabel_temperature)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_temperature, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                        .addComponent(jLabel_rotationalspeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rotationalspeed))
                    .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                        .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_pumpid)
                            .addComponent(jLabel_date)
                            .addComponent(jLabel_pr1)
                            .addComponent(jLabel_pr2)
                            .addComponent(jLabel_pr3)
                            .addComponent(jLabel_volumeflow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_volumeflow)
                            .addComponent(txt_pumpid)
                            .addComponent(txt_date)
                            .addComponent(txt_pr1)
                            .addComponent(txt_pr2)
                            .addComponent(txt_pr3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                    .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmd_savenewdata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_PumpdataLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Label_pumpid, jLabel_date, jLabel_pr1, jLabel_pr2, jLabel_pr3, jLabel_rotationalspeed, jLabel_temperature, jLabel_torque, jLabel_volumeflow});

        jPanel_PumpdataLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_date, txt_pr1, txt_pr2, txt_pr3, txt_pumpid, txt_rotationalspeed, txt_temperature, txt_torque, txt_volumeflow});

        jPanel_PumpdataLayout.setVerticalGroup(
            jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PumpdataLayout.createSequentialGroup()
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_pumpid)
                    .addComponent(txt_pumpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_date)
                    .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pr1)
                    .addComponent(txt_pr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pr2)
                    .addComponent(txt_pr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pr3)
                    .addComponent(txt_pr3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_volumeflow)
                    .addComponent(txt_volumeflow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_temperature)
                    .addComponent(txt_temperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_rotationalspeed)
                    .addComponent(txt_rotationalspeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_PumpdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_torque)
                    .addComponent(txt_torque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_savenewdata)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        jTextField_torque.setBorder(javax.swing.BorderFactory.createTitledBorder("Torque"));

        jTextField_rotspeed.setBorder(javax.swing.BorderFactory.createTitledBorder("Rot. speed"));

        jTextField_temp.setBorder(javax.swing.BorderFactory.createTitledBorder("Temperature"));

        jTextField_volFlow.setBorder(javax.swing.BorderFactory.createTitledBorder("Vol. Flow"));
        jTextField_volFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_volFlowActionPerformed(evt);
            }
        });

        jTextField_pr3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pressure3"));
        jTextField_pr3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pr3ActionPerformed(evt);
            }
        });

        jTextField_pr2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pressure2"));

        jTextField_pr1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pressure1"));
        jTextField_pr1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jSlider1_pressure1.setMajorTickSpacing(5);
        jSlider1_pressure1.setMaximum(20);
        jSlider1_pressure1.setMinorTickSpacing(1);
        jSlider1_pressure1.setPaintLabels(true);
        jSlider1_pressure1.setPaintTicks(true);

        jSlider2_pressure2.setMajorTickSpacing(5);
        jSlider2_pressure2.setMaximum(15);
        jSlider2_pressure2.setMinorTickSpacing(1);
        jSlider2_pressure2.setPaintLabels(true);
        jSlider2_pressure2.setPaintTicks(true);

        jSlider3_pressure3.setMajorTickSpacing(250);
        jSlider3_pressure3.setMaximum(500);
        jSlider3_pressure3.setMinorTickSpacing(100);
        jSlider3_pressure3.setPaintLabels(true);
        jSlider3_pressure3.setPaintTicks(true);

        jSlider4_vol_flow.setMajorTickSpacing(200);
        jSlider4_vol_flow.setMaximum(650);
        jSlider4_vol_flow.setMinorTickSpacing(100);
        jSlider4_vol_flow.setPaintLabels(true);
        jSlider4_vol_flow.setPaintTicks(true);

        jSlider5_temperature.setMajorTickSpacing(20);
        jSlider5_temperature.setMaximum(60);
        jSlider5_temperature.setMinorTickSpacing(10);
        jSlider5_temperature.setPaintLabels(true);
        jSlider5_temperature.setPaintTicks(true);

        jSlider6_rot_speed.setMajorTickSpacing(2000);
        jSlider6_rot_speed.setMaximum(7000);
        jSlider6_rot_speed.setMinorTickSpacing(1000);
        jSlider6_rot_speed.setPaintLabels(true);
        jSlider6_rot_speed.setPaintTicks(true);

        jSlider7_torque.setMajorTickSpacing(100);
        jSlider7_torque.setMaximum(250);
        jSlider7_torque.setMinorTickSpacing(50);
        jSlider7_torque.setPaintLabels(true);
        jSlider7_torque.setPaintTicks(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider7_torque, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider6_rot_speed, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider5_temperature, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider4_vol_flow, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider3_pressure3, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider2_pressure2, 0, 1, Short.MAX_VALUE)
                    .addComponent(jSlider1_pressure1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_torque)
                    .addComponent(jTextField_rotspeed)
                    .addComponent(jTextField_temp)
                    .addComponent(jTextField_volFlow)
                    .addComponent(jTextField_pr3)
                    .addComponent(jTextField_pr2)
                    .addComponent(jTextField_pr1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1_pressure1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jTextField_pr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider2_pressure2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider3_pressure3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pr3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider4_vol_flow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_volFlow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider5_temperature, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_temp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider6_rot_speed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_rotspeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSlider7_torque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_torque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSlider1_pressure1, jSlider2_pressure2, jSlider3_pressure3, jSlider4_vol_flow, jSlider5_temperature, jSlider6_rot_speed, jSlider7_torque});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField_pr1, jTextField_pr2, jTextField_pr3, jTextField_rotspeed, jTextField_temp, jTextField_torque, jTextField_volFlow});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Overall Lights", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel5_redlight.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6_orangelight.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7_greenlight.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Traffic-light-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7_greenlight)
                    .addComponent(jLabel6_orangelight)
                    .addComponent(jLabel5_redlight, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5_redlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6_orangelight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7_greenlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel22)
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setFocusCycleRoot(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel2.setText("Enter Range");

        jLabel3.setText("to");

        jLabel4.setText("Enter Parameter");

        Combo_parameter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "idpump", "Date", "Pressure1", "Pressure2", "Pressure3", "VolumeFlow", "Temperature", "RotationalSpeed", "Torque" }));
        Combo_parameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_parameterActionPerformed(evt);
            }
        });

        txt_endValue.setName("hi"); // NOI18N
        txt_endValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_endValueActionPerformed(evt);
            }
        });

        jLabel15.setText("to");

        jLabel16.setText(" Date Range From");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Windows-Magnifier-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, txt_search});

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Availability", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel19.setText("%");

        jProgressBar_availability_total.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar_availability_total.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar_availability_total.setStringPainted(true);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/man-icon (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_availability_total)
                    .addComponent(jProgressBar_availability_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_availability_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar_availability_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel16)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser_end_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Combo_parameter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_startValue, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(16, 16, 16)
                                .addComponent(txt_endValue, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jDateChooser_start_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_endValue, txt_startValue});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Combo_parameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_startValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_endValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jDateChooser_start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jDateChooser_end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel14.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("User Input", jPanel1);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parameter MIN MAX Values", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel1.setText("Pressure1");

        jLabel6.setText("Pressure2");

        jLabel7.setText("Pressure3");

        jLabel5.setText("Volume Flow");

        jLabel8.setText("Temperature");

        jLabel9.setText("Rot. Speed");

        jLabel10.setText("Torque");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("MAX");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("MIN");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("PARAMETER");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("AVG");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel14))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_pressure3_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_vol_flow_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_temp_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_rot_speed_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pressure2_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_torque_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pressure1_max, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_torque_min, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_temp_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_vol_flow_min)
                            .addComponent(txt_rot_speed_min, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(txt_pressure3_min, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pressure2_min, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pressure1_min, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_pressure1_avg, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(txt_pressure2_avg)
                            .addComponent(txt_pressure3_avg)
                            .addComponent(txt_vol_flow_avg)
                            .addComponent(txt_rot_speed_avg)
                            .addComponent(txt_torque_avg, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txt_temp_avg)))
                    .addComponent(jSeparator1))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_pressure1_max, txt_pressure1_min, txt_pressure2_max, txt_pressure2_min, txt_pressure3_max, txt_pressure3_min, txt_rot_speed_max, txt_rot_speed_min, txt_temp_max, txt_temp_min, txt_torque_max, txt_torque_min, txt_vol_flow_max, txt_vol_flow_min});

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_pressure1_avg, txt_pressure2_avg, txt_pressure3_avg, txt_rot_speed_avg, txt_temp_avg, txt_torque_avg, txt_vol_flow_avg});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_pressure1_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_pressure2_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pressure3_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_vol_flow_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_temp_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rot_speed_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txt_torque_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(txt_pressure1_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pressure2_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pressure3_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_vol_flow_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_temp_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(txt_pressure1_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pressure2_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pressure3_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_vol_flow_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_temp_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rot_speed_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rot_speed_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_torque_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_torque_avg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parameter MIN MAX Values", jPanel12);

        jLabel_no_red.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_no_red.setForeground(new java.awt.Color(204, 0, 0));
        jLabel_no_red.setText("Number of Red Lights are:");

        jLabel_no_orange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_no_orange.setForeground(new java.awt.Color(255, 102, 51));
        jLabel_no_orange.setText("Number of Orange Lights are:");

        jLabel_no_green.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_no_green.setForeground(new java.awt.Color(51, 204, 0));
        jLabel_no_green.setText("Number of Green Lights are:");

        jLabel_field.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel_field.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        traffic_green.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        traffic_green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/traffic-lights-green-icon.png"))); // NOI18N

        traffic_orange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        traffic_orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/traffic-lights-yellow-icon.png"))); // NOI18N

        traffic_red.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        traffic_red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/traffic-lights-red-icon.png"))); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parameter Availability", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel17.setText("%");

        jProgressBar_availability.setStringPainted(true);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/man-icon (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_availability)
                    .addComponent(jProgressBar_availability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar_availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel18)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_field, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                .addComponent(jLabel_no_red))
                            .addComponent(jLabel_no_orange)
                            .addComponent(jLabel_no_green))
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(traffic_green)
                                .addGap(50, 50, 50)
                                .addComponent(traffic_orange)
                                .addGap(54, 54, 54)
                                .addComponent(traffic_red))
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_field, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_no_red)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_no_orange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_no_green)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(traffic_green)
                    .addComponent(traffic_orange)
                    .addComponent(traffic_red))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Remarks", jPanel5);

        Remarks_oneday_ok.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Remarks_oneday_ok.setText("Warning ...");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sign-Alert-icon.png"))); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "General comment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 153, 51))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Possible actions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setText("Schedule maintenance");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("Repair");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("Replace component");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setText("Order component");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Remarks_oneday_ok, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Remarks_oneday_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(15, 15, 15)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Remarks_oneday_ok, jLabel21});

        jTabbedPane1.addTab("Decision Making", jPanel7);

        jLabel23.setText("Document Path (Use Attach button)");

        jTextField1.setText("jTextField1");

        jLabel24.setText("Notes");

        cmd_attach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attach-icon.png"))); // NOI18N
        cmd_attach.setText("Attach");
        cmd_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_attachActionPerformed(evt);
            }
        });

        table_document.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id No.", "Doc. Name", "Notes"
            }
        ));
        table_document.setCellSelectionEnabled(true);
        table_document.setFillsViewportHeight(true);
        table_document.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_documentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_document);

        cmd_save_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/floppy-icon.png"))); // NOI18N
        cmd_save_doc.setText("Save Doc");
        cmd_save_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_save_docActionPerformed(evt);
            }
        });

        jLabel25.setText("Doc Id");

        cmd_delete_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bin-2-icon.png"))); // NOI18N
        cmd_delete_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_delete_docActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(7, 7, 7)
                                .addComponent(txt_notes))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_docid, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmd_delete_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd_attach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd_save_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_document, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(33, 33, 33)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_docid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmd_attach)
                        .addComponent(cmd_save_doc))
                    .addComponent(cmd_delete_doc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txt_notes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Documents", jPanel10);

        jTable1_pumpdata.setAutoCreateRowSorter(true);
        jTable1_pumpdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pressure1", "Pressure2", "Pressure3", "volumeflow", "Temperature", "Rot. Speed", "Torque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_pumpdata.setCellSelectionEnabled(true);
        jTable1_pumpdata.setDoubleBuffered(true);
        jTable1_pumpdata.setDragEnabled(true);
        jTable1_pumpdata.setGridColor(new java.awt.Color(153, 153, 153));
        jTable1_pumpdata.setInheritsPopupMenu(true);
        jTable1_pumpdata.setSurrendersFocusOnKeystroke(true);
        jTable1_pumpdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_pumpdataMouseClicked(evt);
            }
        });
        jTable1_pumpdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1_pumpdataKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_pumpdata);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cmd_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports-icon.png"))); // NOI18N
        cmd_report.setText("Report");
        cmd_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_reportActionPerformed(evt);
            }
        });

        cmd_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-window-close-icon.png"))); // NOI18N
        cmd_close.setText("Close");
        cmd_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_closeActionPerformed(evt);
            }
        });

        cmd_chart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chart-icon.png"))); // NOI18N
        cmd_chart.setText("Chart");
        cmd_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_chartActionPerformed(evt);
            }
        });

        cmd_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/basic-data-icon.png"))); // NOI18N
        cmd_data.setText("Report Pdf");
        cmd_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_dataActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-edit-clear-icon (1).png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmd_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ok-icon.png"))); // NOI18N
        cmd_ok.setText("OK");
        cmd_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmd_report)
                    .addComponent(cmd_close)
                    .addComponent(cmd_chart, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(cmd_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd_data, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(25, 25, 25))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmd_chart, cmd_close, cmd_data, cmd_ok, cmd_report, jButton2});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(cmd_report)
                .addGap(2, 2, 2)
                .addComponent(cmd_close, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_chart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmd_ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jMenuBar1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jMenu1.setText("File");
        jMenu1.add(jSeparator3);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem_aboutus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem_aboutus.setText("About Us");
        jMenuItem_aboutus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_aboutusActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_aboutus);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Help Desk");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);
        jMenu3.add(jSeparator2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_Pumpdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel_Pumpdata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void close() {
WindowEvent winClosingEvent = new WindowEvent( this, WindowEvent.WINDOW_CLOSING );
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent( winClosingEvent );
}
public void okbutton(){

     
        String value1=txt_startValue.getText();
         String value2=txt_endValue.getText();
          //String date1=jDateChooser_start_date.getDate().toString();
       //  String date2=jDateChooser_end_date.getDate().toString();
         String gender=Combo_parameter.getSelectedItem().toString();
         date1= (((JTextField)jDateChooser_start_date.getDateEditor().getUiComponent()).getText());
           date2= (((JTextField)jDateChooser_end_date.getDateEditor().getUiComponent()).getText()); 
          
                //String sql="insert into pump (idpump,Date,Pressure1,Pressure2,Pressure3,VolumeFlow,Temperature,RotationalSpeed,Torque) values(?,?,?,?,?,?,?,?,?)";
      if (gender=="idpump") {
              
    try{
        String sql=" SELECT * FROM pump WHERE idpump BETWEEN '"+value1+"' AND '"+value2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
         }
      else if(gender=="Date"){
       jDateChooser_start_date.setBackground(Color.LIGHT_GRAY);
      try{
         
        String sql=" SELECT * FROM pump WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' order by Date";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }
      
      
       else if(gender=="Pressure1"){
      try{
        String sql=" SELECT * FROM pump WHERE Pressure1 BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
     jLabel_field.setText("Pressure 1");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
          finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }                   
    try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,Pressure1 FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
 
         while(rs.next()){
             double pressure11 = rs.getDouble("pressure1");
             //System.out.println(pressure11);
             
             if(pressure11<=10.0 && pressure11>=0.0){
      
         counter1++;
        }
        if(pressure11 <=11.0 && pressure11>10.0){
       
       counter2++;
        }
        if(pressure11 > 11.0){
      
       counter3++;
        }
        
    }
         String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
          divide1 = (counter1 + counter2 + counter3 );
         divide1 =( avail/divide1 ) * 100;
         
         System.out.printf("Value: %.2f", divide1);
         
         String avail1 = Double.toString(divide1);
         int hello=(int)divide1;
         jProgressBar_availability.setValue(hello);
        float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
        finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }
       
       
        else if(gender=="Pressure2"){
      try{
        String sql=" SELECT * FROM pump WHERE Pressure2 BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
     jLabel_field.setText("Pressure 2");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,Pressure2 FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
  
         while(rs.next()){
             double pressure22 = rs.getDouble("pressure2");
             //System.out.println(pressure22);
             
             if(pressure22<=10.0 && pressure22>=0.0){
      
         counter1++;
        }
        if(pressure22 <=11.0 && pressure22>10.0){
        
       counter2++;
        }
        if(pressure22 > 11.0){
       
       counter3++;
        }
        
    }
         
        String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
          divide2 = (counter1 + counter2 + counter3 );
         divide2 =( avail/divide2 ) * 100;
         int hello=(int)divide2;
         
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide2);
       
         String avail1 = Double.toString(divide2);
         
         float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
        finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }
        
         else if(gender=="Pressure3"){
      try{
        String sql=" SELECT * FROM pump WHERE Pressure3 BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jLabel_field.setText("Pressure 3");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,Pressure3 FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
  //  String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
         while(rs.next()){
             double pressure33 = rs.getDouble("pressure3");
             //System.out.println(pressure33);
             
             if(pressure33<=500 && pressure33>=0){
      
         counter1++;
        }
        if(pressure33 >=501 && pressure33<=525){
        
       counter2++;
        }
        if(pressure33>525){
       
       counter3++;
        }
        
    }
         
       String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
          divide3 = (counter1 + counter2 + counter3 );
         divide3 =( avail/divide3 ) * 100;
         int hello=(int)divide3;
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide3);
      
         String avail1 = Double.toString(divide3);
         float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       
        finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }
         
          else if(gender=="VolumeFlow"){
      try{
        String sql=" SELECT * FROM pump WHERE VolumeFlow BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jLabel_field.setText("Volume Flow");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
           try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,VolumeFlow FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
  //  String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
         while(rs.next()){
             double volumeflow = rs.getDouble("VolumeFlow");
             //System.out.println(volumeflow);
             
         if(volumeflow<=500 && volumeflow>=0){
      
         counter1++;
        }
        if(volumeflow >=501 && volumeflow>=525){
        
       counter2++;
        }
        if(volumeflow>525){
       
       counter3++;
        }
        
        
        
        
        
        
        
        
        
    }
         
        String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
          divide4 = (counter1 + counter2 + counter3 );
         divide4 =( avail/divide4 ) * 100;
         int hello=(int)divide4;
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide4);
        
         String avail1 = Double.toString(divide4);
         
        float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
      
      }
          
          
           else if(gender=="Temperature"){
      
      try{
        String sql=" SELECT * FROM pump WHERE Temperature BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jLabel_field.setText("Temperature");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,Temperature FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
  //  String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
         while(rs.next()){
             double Temperature1 = rs.getDouble("Temperature");
             //System.out.println(Temperature1);
             
         if(Temperature1<=60 && Temperature1>=0){
      
         counter1++;
        }
        if(Temperature1 <=0 && Temperature1>=-3  ||  (Temperature1 >=60 && Temperature1<=63)){
        
       counter2++;
        }
        if(Temperature1>63){
       
       counter3++;
        }
        
      
        
        
        
        
    }
         
       String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
         divide5 = (counter1 + counter2 + counter3 );
         divide5 =( avail/divide5 ) * 100;
         int hello=(int)divide5;
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide5);
         
         String avail1 = Double.toString(divide5);
       float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
     
        finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      
      }
           
           
        else if(gender=="RotationalSpeed"){
      try{
        String sql=" SELECT * FROM pump WHERE RotationalSpeed BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jLabel_field.setText("Rotational Speed");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
       try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,RotationalSpeed FROM pump  WHERE Date BETWEEN '"+date1+"' AND '"+date2+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
  //  String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
         while(rs.next()){
             double rotationalspeed1 = rs.getDouble("RotationalSpeed");
             //System.out.println(rotationalspeed1);
             
         if(rotationalspeed1<=6000){
      
         counter1++;
        }
        if(rotationalspeed1  <=6120 && rotationalspeed1>=6001 ){
        
       counter2++;
        }
        if(rotationalspeed1>6120){
       
       counter3++;
        }
        
       
        
        
        
    }
        String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1);
         double  avail = (counter1 + counter2);
          divide6 = (counter1 + counter2 + counter3 );
         divide6 =( avail/divide6 ) * 100;
         int hello=(int)divide6;
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide6);
        
         String avail1 = Double.toString(divide6);
         float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
     
        finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      
      
      }           

        
            else if(gender=="Torque"){
      try{
        String sql=" SELECT * FROM pump WHERE Torque BETWEEN '"+value1+"' AND '"+value2+"' and Date BETWEEN '"+date1+"' AND '"+date2+"' order by idpump";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jLabel_field.setText("Torque");
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      try{
        int counter1 = 0,counter2 = 0,counter3 = 0;
        
        
        String sql1=" SELECT idpump,Date,Torque FROM pump   WHERE Date BETWEEN '"+date1+"' AND '"+date2+"'";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
  //  String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
         while(rs.next()){
             double torque1 = rs.getDouble("Torque");
            // System.out.println(torque1);
             
         if(torque1 <=200 && torque1>=0){
      
         counter1++;
        }
        if(torque1  <=210 && torque1>=201){
        
       counter2++;
        }
        if(torque1>210){
       
       counter3++;
        }
        
        
    
        
        
        
        
    }
         
       String red1 = Double.toString(counter3);
            jLabel_no_red.setText("Number of Red Lights are    :"+red1);
            traffic_red.setText(red1);
         String orange1 = Double.toString(counter2);
         jLabel_no_orange.setText("Number of Orange Lights are :"+orange1);
         traffic_orange.setText(orange1);
         String green1 = Double.toString(counter1);
          jLabel_no_green.setText("Number of Green Lights are  :"+green1);  
          traffic_green.setText(green1); 
         double  avail = (counter1 + counter2);
          divide7 = (counter1 + counter2 + counter3 );
         divide7 =( avail/divide7 ) * 100;
         int hello=(int)divide7;
         jProgressBar_availability.setValue(hello);
         System.out.printf("Value: %.2f", divide7);
         
         String avail1 = Double.toString(divide7);
           float x = Float.parseFloat(avail1);
    
    int decimalPlace = 2;
    BigDecimal bd = new BigDecimal(x);
    bd = bd.setScale(decimalPlace,BigDecimal.ROUND_UP);
    x = bd.floatValue();
         String avail11 = Float.toString(x);
           txt_availability.setText(avail11);
        
    }
    catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
     
       finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }     
                 } 
        
        
      else{
           try{
        String sql=" SELECT * FROM pump ";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));  
    
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             finally {
  
try{
  
rs.close();
   pst.close();
    // conn.close();
  
}
  
catch(Exception e) {
  
}
      }     
      
      
      
      }
}
public void tableclick(){

 int row =jTable1_pumpdata.getSelectedRow();
       txt_pumpid.setText(jTable1_pumpdata.getModel().getValueAt(row, 0).toString());
       txt_date.setText(jTable1_pumpdata.getModel().getValueAt(row, 1).toString());
       txt_pr1.setText(jTable1_pumpdata.getModel().getValueAt(row, 2).toString());
       txt_pr2.setText(jTable1_pumpdata.getModel().getValueAt(row, 3).toString());
       txt_pr3.setText(jTable1_pumpdata.getModel().getValueAt(row, 4).toString());
       txt_volumeflow.setText(jTable1_pumpdata.getModel().getValueAt(row, 5).toString());
       txt_temperature.setText(jTable1_pumpdata.getModel().getValueAt(row, 6).toString());
       txt_rotationalspeed.setText(jTable1_pumpdata.getModel().getValueAt(row, 7).toString());
      txt_torque.setText(jTable1_pumpdata.getModel().getValueAt(row, 8).toString());
      
      
       
       int counter1=0,counter2=0,counter3=0;
          
                    
    try{
        
        String sql1=" SELECT MAX(Pressure1) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String pr1=rs.getString("MAX(Pressure1)");
    // int pe1 =Integer.parseInt(pr1);
  // jTextField_pr1.setText(pr1);
    // int Max_pressure1=Integer.parseInt(add1);
    //jSlider1_pressure1.setMaximum(Max_pressure1);
     
    int pressure1 =Integer.parseInt(txt_pr1.getText());
        jSlider1_pressure1.setValue(pressure1);
        
        String pre1=txt_pr1.getText();
         jTextField_pr1.setText(pre1+" Bar");
             if(pressure1<=10 && pressure1>=0){
        jTextField_pr1.setBackground( Color.GREEN);
       jTextField_pr1.setForeground(Color.black);
      
         counter1++;
        }
        if(pressure1 <=11 && pressure1>10){
        jTextField_pr1.setBackground( Color.ORANGE);
       jTextField_pr1.setForeground(Color.black);
       counter2++;
      
        }
        if(pressure1>11){
       jTextField_pr1.setBackground( Color.RED);
       jTextField_pr1.setForeground(Color.black);
       counter3++;
     
        }
        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
    try{
        
        String sql1=" SELECT MAX(Pressure2) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String pr2=rs.getString("MAX(Pressure2)");
   //jTextField_pr2.setText(pr2);
    // int Max_pressure2=Integer.parseInt(pr2);
    //jSlider2_pressure2.setMaximum(Max_pressure2);
     
        String pre2=txt_pr2.getText();
         jTextField_pr2.setText(pre2+" Bar");
     int pressure2 =Integer.parseInt(txt_pr2.getText());
        jSlider2_pressure2.setValue(pressure2);
           if(pressure2<=10 && pressure2>=0){
        jTextField_pr2.setBackground( Color.GREEN);
       jTextField_pr2.setForeground(Color.black);
       counter1++;
        }
        if(pressure2 <=11 && pressure2>10){
        jTextField_pr2.setBackground( Color.ORANGE);
       jTextField_pr2.setForeground(Color.black);
       counter2++;
        }
        if(pressure2>11){
       jTextField_pr2.setBackground( Color.RED);
       jTextField_pr2.setForeground(Color.black);
       counter3++;
        }
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
         finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }     
          try{
        
        String sql1=" SELECT MAX(Pressure3) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String pr3=rs.getString("MAX(Pressure3)");
   //jTextField_pr3.setText(pr3);
    // int Max_pressure3=Integer.parseInt(pr3);
   // jSlider3_pressure3.setMaximum(Max_pressure3);
      String pre3=txt_pr3.getText();
         jTextField_pr3.setText(pre3+" Bar");
     int pressure3 =Integer.parseInt(txt_pr3.getText());
        jSlider3_pressure3.setValue(pressure3);
        
            if(pressure3<=500 && pressure3>=0){
        jTextField_pr3.setBackground( Color.GREEN);
       jTextField_pr3.setForeground(Color.black);
       counter1++;
        }
        if(pressure3 >=501 && pressure3<=525 ){
        jTextField_pr3.setBackground( Color.ORANGE);
       jTextField_pr3.setForeground(Color.black);
       counter2++;
        }
        if(pressure3>525){
       jTextField_pr3.setBackground( Color.RED);
       jTextField_pr3.setForeground(Color.black);
       counter3++;
        }
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
               try{
        
        String sql1=" SELECT MAX(VolumeFlow) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String vol_flo=rs.getString("MAX(VolumeFlow)");
  // jTextField_volFlow.setText(vol_flo);
     //int Max_vol_flo=Integer.parseInt(vol_flo);
  //  jSlider4_vol_flow.setMaximum(Max_vol_flo);
     
      String vol_f=txt_volumeflow.getText();
         jTextField_volFlow.setText(vol_f+" m³/h");
         int volumeflow =Integer.parseInt(txt_volumeflow.getText());
        jSlider4_vol_flow.setValue(volumeflow);
        
          if(volumeflow<=500 && volumeflow>=0){
        jTextField_volFlow.setBackground( Color.GREEN);
       jTextField_volFlow.setForeground(Color.black);
       counter1++;
        }
        if(volumeflow >=501 && volumeflow>=525 ){
        jTextField_volFlow.setBackground( Color.ORANGE);
       jTextField_volFlow.setForeground(Color.black);
       counter2++;
        }
        if(volumeflow>525){
       jTextField_volFlow.setBackground( Color.RED);
       jTextField_volFlow.setForeground(Color.black);
       counter3++;
        }
        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }  finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
                    try{
        
        String sql1=" SELECT MAX(Temperature) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String temp=rs.getString("MAX(Temperature)");
 //  jTextField_temp.setText(temp);
    // int Max_temp=Integer.parseInt(temp);
   // jSlider5_temperature.setMaximum(Max_temp);
     
    
      String temp1=txt_temperature.getText();
         jTextField_temp.setText(temp1+" °C");
        
           int temperature =Integer.parseInt(txt_temperature.getText());
        jSlider5_temperature.setValue(temperature);
        
          if(temperature<=60 && temperature>=0){
        jTextField_temp.setBackground( Color.GREEN);
       jTextField_temp.setForeground(Color.black);
       counter1++;
        }
        if((temperature <=0 && temperature>=-3)  || (temperature >=60 && temperature<=63) ){
        jTextField_temp.setBackground( Color.ORANGE);
       jTextField_temp.setForeground(Color.black);
       counter2++;
        }
        if(temperature>63){
       jTextField_temp.setBackground( Color.RED);
       jTextField_temp.setForeground(Color.black);
       counter3++;
        }
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
        finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
                        try{
        
        String sql1=" SELECT MAX(RotationalSpeed) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String rot_speed=rs.getString("MAX(RotationalSpeed)");
   //jTextField_rotspeed.setText(rot_speed);
     //int Max_rot_speed=Integer.parseInt(rot_speed);
    //jSlider6_rot_speed.setMaximum(Max_rot_speed);
     
      String rot_spe=txt_rotationalspeed.getText();
         jTextField_rotspeed.setText(rot_spe+" rpm");
     
          int rotationalspeed =Integer.parseInt(txt_rotationalspeed.getText());
        jSlider6_rot_speed.setValue(rotationalspeed);
        
        
         if(rotationalspeed<=6000){
        jTextField_rotspeed.setBackground( Color.GREEN);
       jTextField_rotspeed.setForeground(Color.black);
       counter1++;
        }
        if(rotationalspeed  <=6120 && rotationalspeed>=6001 ){
        jTextField_rotspeed.setBackground( Color.ORANGE);
       jTextField_rotspeed.setForeground(Color.black);
       counter2++;
        }
        if(rotationalspeed>6120){
        jTextField_rotspeed.setBackground( Color.RED);
       jTextField_rotspeed.setForeground(Color.black);
       counter3++;
        }
        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
           finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
   //  conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }                    try{
        
        String sql1=" SELECT MAX(Torque) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String torqu=rs.getString("MAX(Torque)");
   //jTextField_torque.setText(torqu);
    // int Max_torque=Integer.parseInt(torqu);
   // jSlider7_torque.setMaximum(Max_torque);
     
    String torq=txt_torque.getText();
         jTextField_torque.setText(torq+" Nm");
     
   
     int torque =Integer.parseInt(txt_torque.getText());
        jSlider7_torque.setValue(torque);
        
        
        
        
        
        if(torque  <=200 && torque>=0){
        jTextField_torque.setBackground( Color.GREEN);
       jTextField_torque.setForeground(Color.black);
       counter1++;
        }
        if(torque  <=210 && torque>=201 ){
        jTextField_torque.setBackground( Color.ORANGE);
       jTextField_torque.setForeground(Color.black);
       counter2++;
        }
        if(torque>210){
        jTextField_torque.setBackground( Color.RED);
       jTextField_torque.setForeground(Color.black);
       counter3++;
        }
        jLabel7_greenlight.setText(String.valueOf(counter1));
        jLabel6_orangelight.setText(String.valueOf(counter2));
        jLabel5_redlight.setText(String.valueOf(counter3));
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);
             
    }  finally {
try{
  rs.close();
   pst.close();
     // conn.close();
  }
  catch(Exception e) {
                   }finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }  
      }  
         
        if(counter3>=1 || counter2>=3){
        
         jLabel5_redlight.setBackground( Color.RED);
         jLabel6_orangelight.setBackground( Color.WHITE);
         jLabel7_greenlight.setBackground( Color.WHITE);
       jLabel5_redlight.setForeground(Color.black);
       Remarks_oneday_ok.setText("The pump must be repaired");
        }
        else if(counter2<=2 && counter2>=1 ){
         jLabel6_orangelight.setBackground( Color.ORANGE);
          jLabel5_redlight.setBackground( Color.WHITE);
          jLabel7_greenlight.setBackground( Color.WHITE);
       jLabel6_orangelight.setForeground(Color.black);
        Remarks_oneday_ok.setText("Schedule maintenance for the pump ");
        
        }
        else 
        {
        jLabel7_greenlight.setBackground( Color.GREEN);
        jLabel5_redlight.setBackground( Color.WHITE);
         jLabel6_orangelight.setBackground( Color.WHITE);
       jLabel7_greenlight.setForeground(Color.black);
          Remarks_oneday_ok.setText("The pump is in good working condition");
        }



}
    private void cmd_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_okActionPerformed
   okbutton()   ;
      
    Availability();
       
      
    }//GEN-LAST:event_cmd_okActionPerformed

    private void Combo_parameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_parameterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_parameterActionPerformed

    private void cmd_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_reportActionPerformed
                  
         try{
         String report="Proma2.jrxml";
                    
      // JasperDesign Jasperdesign =JRXmlLoader.load("myreport1.jrxml");
       // String sql ="select * from table2";
        //JRDesignQuery newQuery= new JRDesignQuery();
        //newQuery.setText(sql);
        //Jasperdesign.setQuery(newQuery);
        JasperReport jr =JasperCompileManager.compileReport(report);
                JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
        JasperViewer.viewReport(jp);
        
        }
         catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
          finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }   
    }//GEN-LAST:event_cmd_reportActionPerformed

    private void cmd_savenewdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_savenewdataActionPerformed
        
        
         String sql="insert into pump (idpump,Date,Pressure1,Pressure2,Pressure3,VolumeFlow,Temperature,RotationalSpeed,Torque) values(?,?,?,?,?,?,?,?,?)";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, txt_pumpid.getText());
    pst.setString(2, txt_date.getText());
    pst.setString(3, txt_pr1.getText());
    pst.setString(4, txt_pr2.getText());
    pst.setString(5, txt_pr3.getText());
    pst.setString(6, txt_volumeflow.getText());
    pst.setString(7, txt_temperature.getText());
    pst.setString(8, txt_rotationalspeed.getText());
     pst.setString(9, txt_torque.getText());
   // rs=pst.executeQuery();
    pst.execute();
    
    JOptionPane.showMessageDialog(null, "Saved");
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
       finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }     
    }//GEN-LAST:event_cmd_savenewdataActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        
        //String idpumpsearch=txt_endDate.getText();
                    String sql=" SELECT * FROM pump WHERE   idpump =?";
    try{
    /*pst =conn.prepareStatement(sql);
    
     //pst.setString(1,txt_search.getText()+"%");
     rs=pst.executeQuery();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));
   */
       //String sql="select * from employee_data where Employeeid=? ";
    pst =conn.prepareStatement(sql);
   pst.setString(1,txt_search.getText());
  

    rs=pst.executeQuery();
   // pst.execute();
  
  //  String add1=rs.getString("idpump");
  jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));
    if(rs.next()){
    String add1=rs.getString("idpump");
    txt_pumpid.setText(add1);
    String add2=rs.getString("Date");
   txt_date.setText(add2);
   String add3=rs.getString("Pressure2");
     txt_pr1.setText(add3);
    String add4=rs.getString("Job_Title");
   txt_pr2.setText(add4);
    
    String add5=rs.getString("Pressure3");
    txt_pr3.setText(add5);
    String add6=rs.getString("VolumeFlow");
   txt_volumeflow.setText(add6);
   String add7=rs.getString("Temperature");
    txt_temperature.setText(add7);
    String add8=rs.getString("RotationalSpeed");
    txt_rotationalspeed.setText(add8);
    
    String add9=rs.getString("Torque");
    txt_torque.setText(add9);
    
   
    }        
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
         finally {
try{
  rs.close();
   pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      }   
    }//GEN-LAST:event_txt_searchKeyReleased

    private void jTextField_pr3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pr3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pr3ActionPerformed

    private void cmd_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_chartActionPerformed
        Chart_JFrame s=new Chart_JFrame();
              s.setVisible(true);
              close1();
     /*    String value1=txt_startValue.getText();
         String value2=txt_endValue.getText();
         String gender=Combo_parameter.getSelectedItem().toString();
         
                //String sql="insert into pump (idpump,Date,Pressure1,Pressure2,Pressure3,VolumeFlow,Temperature,RotationalSpeed,Torque) values(?,?,?,?,?,?,?,?,?)";
      if (gender=="All") {
              
    try{
        JOptionPane.showMessageDialog(null, "Please Select a Parameter from fields below");
               
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
         }
      else if(gender=="Date"){
      
       
              try{
        
        String sql1=" SELECT Count(Date) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Date)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT date FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("date");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
       final DateFormat df = DateFormat.getInstance();
       
     series.add(i, value_pr1_intform);
      
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart(" Date Graph", "X axis", "Y axis", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("Date",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      }
      
      
       else if(gender=="Pressure1"){
     
              try{
        
        String sql1=" SELECT Count(pressure1) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure1)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure1 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure1");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
        
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("Pressure1 Graph", "X axis", "Pressure1", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("Pressure1",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
           
           
      }
       
       
        else if(gender=="Pressure2"){
        try{
        
        String sql1=" SELECT Count(pressure2) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure2)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure2 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure2");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Pressure2 Graph", "X axis", "Pressure2", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame(" Pressure2 Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
        
         else if(gender=="Pressure3"){
        try{
        
        String sql1=" SELECT Count(pressure3) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure3)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure3 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure3");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Pressure3 Graph", "X axis", "Pressure3", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame(" Pressure3 Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
         
          else if(gender=="VolumeFlow"){
        try{
        
        String sql1=" SELECT Count(VolumeFlow) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(VolumeFlow)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT VolumeFlow FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("VolumeFlow");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY VolumeFlow Graph", "X axis", "VolumeFlow", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame(" VolumeFlow Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
          
          
           else if(gender=="Temperature"){
      
       try{
        
        String sql1=" SELECT Count(Temperature) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Temperature)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT Temperature FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("Temperature");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Temperature Graph", "X axis", "Temperature", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame(" Temperature Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      }
           
           
        else if(gender=="RotationalSpeed"){
        try{
        
        String sql1=" SELECT Count(RotationalSpeed) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(RotationalSpeed)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT RotationalSpeed FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("RotationalSpeed");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY RotationalSpeed Graph", "X axis", "RotationalSpeed", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("RotationalSpeed Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }           

        
            else if(gender=="Torque"){
        try{
        
        String sql1=" SELECT Count(Torque) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Torque)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT Torque FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("Torque");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Torque Graph", "X axis", "Torque", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame(" Torque Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      } 
        
        
      else{
           try{
        String sql=" SELECT * FROM pump ";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      
      
      }
      
        
       
        
        
        */
     
       // XYSeries series =new XYSeries("Graph");
       /* series.add(1, 1);
        series.add(1, 2);
        series.add(2, 5);
        series.add(3, 4);
        series.add(1, 3);

         XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("Xy Graph", "X axis", "Y axis", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("Hello",chart);
        frame.pack();
        frame.setVisible(true);*/
    }//GEN-LAST:event_cmd_chartActionPerformed

    private void jTextField_volFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_volFlowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_volFlowActionPerformed

    private void txt_endValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_endValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_endValueActionPerformed

    private void jTable1_pumpdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_pumpdataMouseClicked
       tableclick();
     
    }//GEN-LAST:event_jTable1_pumpdataMouseClicked

    private void jTable1_pumpdataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1_pumpdataKeyPressed
        // TODO add your handling code here:
      //  int key = evt.getKeyCode();
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP ){
        
        tableclick();
        }
    }//GEN-LAST:event_jTable1_pumpdataKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    txt_pumpid.setText("");
   
   txt_date.setText("");
  
     txt_pr1.setText("");
    
   txt_pr2.setText("");
    
   
    txt_pr3.setText("");
    
   txt_volumeflow.setText("");
   
    txt_temperature.setText("");
    
    txt_rotationalspeed.setText("");
   
    txt_torque.setText("");
    
     jLabel5_redlight.setText("");
         jLabel6_orangelight.setText("");
         jLabel7_greenlight.setText("");
         
         jTextField_pr1.setText("");
         jTextField_pr2.setText("");
         jTextField_pr3.setText(""); 
         
         jTextField_volFlow.setText("");
                 jTextField_temp.setText("");
                 jTextField_rotspeed.setText("");
                 jTextField_torque.setText("");
                 txt_startValue.setText("");
                 txt_endValue.setText("");
                 txt_availability.setText("");
                 jDateChooser_start_date.setDate(null);
                 jDateChooser_end_date.setDate(null);        
         
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmd_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_closeActionPerformed
 System.exit(0);
        close();
       // Table_JFrame p = new Table_JFrame();
      // p.setVisible(true);
        
    }//GEN-LAST:event_cmd_closeActionPerformed

    private void cmd_report1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_report1ActionPerformed
                         
        try{
         String report="C:\\Users\\9589693153\\Documents\\NetBeansProjects\\PROMA\\Proma2.jrxml";
                    
      // JasperDesign Jasperdesign =JRXmlLoader.load("myreport1.jrxml");
       // String sql ="select * from table2";
        //JRDesignQuery newQuery= new JRDesignQuery();
        //newQuery.setText(sql);
        //Jasperdesign.setQuery(newQuery);
        JasperReport jr =JasperCompileManager.compileReport(report);
                JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
        JasperViewer.viewReport(jp);
        
        }
         catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
   
    }//GEN-LAST:event_cmd_report1ActionPerformed

    private void cmd_chart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_chart1ActionPerformed
            Chart_JFrame s=new Chart_JFrame();
              s.setVisible(true);
                close1();
        
        
        /*    String value1=txt_startValue.getText();
         String value2=txt_endValue.getText();
         String gender=Combo_parameter.getSelectedItem().toString();
         
                //String sql="insert into pump (idpump,Date,Pressure1,Pressure2,Pressure3,VolumeFlow,Temperature,RotationalSpeed,Torque) values(?,?,?,?,?,?,?,?,?)";
      if (gender=="All") {
              
    try{
        JOptionPane.showMessageDialog(null, "Please Select a Parameter from fields below");
               
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
         }
      else if(gender=="Date"){
      
       
              try{
        
        String sql1=" SELECT Count(Date) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Date)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT date FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("date");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
       final DateFormat df = DateFormat.getInstance();
       
     series.add(i, value_pr1_intform);
      
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Date Graph", "X axis", "Y axis", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("Date",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      }
      
      
       else if(gender=="Pressure1"){
     
              try{
        
        String sql1=" SELECT Count(pressure1) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure1)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure1 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure1");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Pressure1 Graph", "X axis", "Pressure1", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("Pressure1",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
           
           
      }
       
       
        else if(gender=="Pressure2"){
        try{
        
        String sql1=" SELECT Count(pressure2) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure2)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure2 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure2");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Pressure2 Graph", "X axis", "Pressure2", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY Pressure2 Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
        
         else if(gender=="Pressure3"){
        try{
        
        String sql1=" SELECT Count(pressure3) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(pressure3)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT pressure3 FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("pressure3");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Pressure3 Graph", "X axis", "Pressure3", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY Pressure3 Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
         
          else if(gender=="VolumeFlow"){
        try{
        
        String sql1=" SELECT Count(VolumeFlow) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(VolumeFlow)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT VolumeFlow FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("VolumeFlow");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY VolumeFlow Graph", "X axis", "VolumeFlow", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY VolumeFlow Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }
          
          
           else if(gender=="Temperature"){
      
       try{
        
        String sql1=" SELECT Count(Temperature) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Temperature)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT Temperature FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("Temperature");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Temperature Graph", "X axis", "Temperature", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY Temperature Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      }
           
           
        else if(gender=="RotationalSpeed"){
        try{
        
        String sql1=" SELECT Count(RotationalSpeed) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(RotationalSpeed)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT RotationalSpeed FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("RotationalSpeed");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY RotationalSpeed Graph", "X axis", "RotationalSpeed", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY RotationalSpeed Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      }           

        
            else if(gender=="Torque"){
        try{
        
        String sql1=" SELECT Count(Torque) FROM pump  ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
    
   // pst.setString(1, jTextField1.getText());
    String count_pr1=rs.getString("Count(Torque)");
      count_p1_intform =Integer.parseInt(count_pr1);
        
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
             try{
        
      
            // pst.setString(1, jTextField1.getText());
    XYSeries series =new XYSeries("Graph");
    for(int i=1;i<=count_p1_intform;i++){
          String sql1=" SELECT Torque FROM pump where idpump ='"+i+"' ";
    pst =conn.prepareStatement(sql1);
    rs=pst.executeQuery();
         String  value_pr1 = rs.getString("Torque");
     int value_pr1_intform =Integer.parseInt(value_pr1);
     
        series.add(i, value_pr1_intform);
    }
     XYSeriesCollection dataset =new XYSeriesCollection();
         dataset.addSeries(series);
         JFreeChart chart =ChartFactory.createXYLineChart("XY Torque Graph", "X axis", "Torque", dataset, PlotOrientation.VERTICAL, true,true,false);
        ChartFrame frame = new ChartFrame("XY Torque Graph",chart);
        frame.pack();
        frame.setVisible(true);
    
         }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      } 
        
        
      else{
           try{
        String sql=" SELECT * FROM pump ";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
    jTable1_pumpdata.setModel(DbUtils.resultSetToTableModel(rs));        
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }
      
      
      
      }
      
        
        */
        
        
    }//GEN-LAST:event_cmd_chart1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         txt_pumpid.setText("");
   
   txt_date.setText("");
  
     txt_pr1.setText("");
    
   txt_pr2.setText("");
    
   
    txt_pr3.setText("");
    
   txt_volumeflow.setText("");
   
    txt_temperature.setText("");
    
    txt_rotationalspeed.setText("");
   
    txt_torque.setText("");
    
     jLabel5_redlight.setText("");
         jLabel6_orangelight.setText("");
         jLabel7_greenlight.setText("");
         
         jTextField_pr1.setText("");
         jTextField_pr2.setText("");
         jTextField_pr3.setText(""); 
         
         jTextField_volFlow.setText("");
                 jTextField_temp.setText("");
                 jTextField_rotspeed.setText("");
                 jTextField_torque.setText("");
                 txt_startValue.setText("");
                 txt_endValue.setText("");
                 txt_availability.setText("");
                 jDateChooser_start_date.setDate(null);
                 jDateChooser_end_date.setDate(null);        
         
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cmd_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_ok1ActionPerformed
             
  okbutton();
      
    }//GEN-LAST:event_cmd_ok1ActionPerformed

    private void cmd_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_close1ActionPerformed
        System.exit(0); 
        close();
         
       // Table_JFrame p = new Table_JFrame();
      // p.setVisible(true);
        
    }//GEN-LAST:event_cmd_close1ActionPerformed

    private void cmd_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_dataActionPerformed
    report(); 
    }//GEN-LAST:event_cmd_dataActionPerformed

    private void jMenuBar1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenuBar1AncestorAdded
       
    }//GEN-LAST:event_jMenuBar1AncestorAdded

    private void jMenuItem_aboutusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_aboutusActionPerformed
        About_us p=new About_us();
       p.setVisible(true);
    }//GEN-LAST:event_jMenuItem_aboutusActionPerformed

    private void cmd_data1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_data1ActionPerformed
     report();
    }//GEN-LAST:event_cmd_data1ActionPerformed

    private void txt_torqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_torqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_torqueActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
       
        String d=textArea1.getText();
        MessageFormat header = new MessageFormat("PROMA ");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}      "+"1.General comment:"+d+"  2.Possible actions:"+possibleaction);
        try {
            jTable1_pumpdata.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, null, true, null);
            //table.print(JTable.PrintMode.FIT_WIDTH, header, null);
           // jTable1_pumpdata.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }  finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
    }//GEN-LAST:event_cmd_printActionPerformed

    private void cmd_SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_SignOutActionPerformed
             try{
  rs.close();
      pst.close();
     conn.close();
  }
  catch(Exception e) {
                   }
        
        Login_PROMA_Frame s = new Login_PROMA_Frame();
    s.setVisible(true);
    

   close1();
    }//GEN-LAST:event_cmd_SignOutActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
          possibleaction="Order component";
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
     int p = JOptionPane.showConfirmDialog(null,"Do you really want to delete","Add Data",JOptionPane.YES_NO_OPTION);  
     if(p==0){
         String sql="delete from pump where idpump=?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, txt_pumpid.getText());
    
   // rs=pst.executeQuery();
    pst.execute();
    
    JOptionPane.showMessageDialog(null, "Deleted");
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
     }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          try                                      //try statement
     {
         Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\9589693153\\Documents\\NetBeansProjects\\PROMA\\Frequently Asked Questions.pdf");   //open the file chart.pdf

     } catch (Exception e)                    //catch any exceptions here
       {
            JOptionPane.showMessageDialog(null,"Error");  //print the error
       }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        possibleaction="Repair";
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
          possibleaction="Replace component";
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
          possibleaction="Schedule maintenance";
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void cmd_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_attachActionPerformed
        JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                System.out.println("You have selected: " + filename);
                txt_document.setText(filename);
                 File_path =filename ;
    }//GEN-LAST:event_cmd_attachActionPerformed

    private void cmd_save_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_save_docActionPerformed
           try{
                    String sql="INSERT INTO Document_table(Attach_path,Notes,idnew_table)VALUES(?,?,?)";

  pst =conn.prepareStatement(sql);
    pst.setString(1, txt_document.getText());
    pst.setString(2, txt_notes.getText());
    pst.setString(3, txt_docid.getText());
      
                      pst.execute();
    
    JOptionPane.showMessageDialog(null, "Document Saved");
                 }
                 catch (Exception e)                    //catch any exceptions here
       {
            JOptionPane.showMessageDialog(null,e);  //print the error
       }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
                       
                 }   
           Update_doc_table();
             
    }//GEN-LAST:event_cmd_save_docActionPerformed

    private void table_documentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_documentMouseClicked
                    int row =table_document.getSelectedRow();
       String txt_doc=(table_document.getModel().getValueAt(row, 1).toString());
        
             try                                      //try statement
     {
         Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + txt_doc);   //open the file chart.pdf

     } catch (Exception e)                    //catch any exceptions here
       {
            JOptionPane.showMessageDialog(null,"Error");  //print the error
       }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }
             
             
             
                 try{
              int row1 =table_document.getSelectedRow();
       String txt_Employeeid=(table_document.getModel().getValueAt(row1, 0).toString());
        String sql="select Attach_path,Notes,idnew_table from Document_table where  idnew_table='"+txt_Employeeid+"' ";
    pst =conn.prepareStatement(sql);
    rs=pst.executeQuery();
    //pst.execute();
            if(rs.next()){
    String add1=rs.getString("idnew_table");
    txt_docid.setText(add1);
    String add2=rs.getString("Attach_path");
   txt_document.setText(add2);
   String add3=rs.getString("Notes");
     txt_notes.setText(add3);
   
    

    } 
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    } finally {
try{
  rs.close();
      pst.close();
    // conn.close();
  }
  catch(Exception e) {
                   }
      } 
             
    }//GEN-LAST:event_table_documentMouseClicked

    private void cmd_delete_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_delete_docActionPerformed
         int p = JOptionPane.showConfirmDialog(null,"Do you really want to delete","Add Data",JOptionPane.YES_NO_OPTION);  
     if(p==0){
         String sql="delete from Document_table where idnew_table=?";
         try{
    pst =conn.prepareStatement(sql);
    pst.setString(1, txt_docid.getText());
    
   // rs=pst.executeQuery();
    pst.execute();
    
    JOptionPane.showMessageDialog(null, "Deleted");
    //QueryJFrame s = new QueryJFrame();
    //s.setVisible(true);
    
    
    
    
            
    }catch(Exception e)
    {
           JOptionPane.showMessageDialog(null, e);

    }finally {
try{
  rs.close();
   pst.close();
     //conn.close();
  }
  catch(Exception e) {
                   }
      }  
     }
       Update_doc_table();
    }//GEN-LAST:event_cmd_delete_docActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new User_JFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_parameter;
    private javax.swing.JLabel Label_pumpid;
    private javax.swing.JLabel Lbl_Date;
    private javax.swing.JLabel Remarks_oneday_ok;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmd_SignOut;
    private javax.swing.JButton cmd_attach;
    private javax.swing.JButton cmd_chart;
    private javax.swing.JButton cmd_chart1;
    private javax.swing.JButton cmd_close;
    private javax.swing.JButton cmd_close1;
    private javax.swing.JButton cmd_data;
    private javax.swing.JButton cmd_data1;
    private javax.swing.JButton cmd_delete_doc;
    private javax.swing.JButton cmd_ok;
    private javax.swing.JButton cmd_ok1;
    private javax.swing.JButton cmd_print;
    private javax.swing.JButton cmd_report;
    private javax.swing.JButton cmd_report1;
    private javax.swing.JButton cmd_save_doc;
    private javax.swing.JButton cmd_savenewdata;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private com.toedter.calendar.JDateChooser jDateChooser_end_date;
    private com.toedter.calendar.JDateChooser jDateChooser_start_date;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jLabel5_redlight;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jLabel6_orangelight;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jLabel7_greenlight;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_field;
    private javax.swing.JLabel jLabel_no_green;
    private javax.swing.JLabel jLabel_no_orange;
    private javax.swing.JLabel jLabel_no_red;
    private javax.swing.JLabel jLabel_pr1;
    private javax.swing.JLabel jLabel_pr2;
    private javax.swing.JLabel jLabel_pr3;
    private javax.swing.JLabel jLabel_rotationalspeed;
    private javax.swing.JLabel jLabel_temperature;
    private javax.swing.JLabel jLabel_torque;
    private javax.swing.JLabel jLabel_volumeflow;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_aboutus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Pumpdata;
    private javax.swing.JProgressBar jProgressBar_availability;
    private javax.swing.JProgressBar jProgressBar_availability_total;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSlider jSlider1_pressure1;
    private javax.swing.JSlider jSlider2_pressure2;
    private javax.swing.JSlider jSlider3_pressure3;
    private javax.swing.JSlider jSlider4_vol_flow;
    private javax.swing.JSlider jSlider5_temperature;
    private javax.swing.JSlider jSlider6_rot_speed;
    private javax.swing.JSlider jSlider7_torque;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1_pumpdata;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_pr1;
    private javax.swing.JTextField jTextField_pr2;
    private javax.swing.JTextField jTextField_pr3;
    private javax.swing.JTextField jTextField_rotspeed;
    private javax.swing.JTextField jTextField_temp;
    private javax.swing.JTextField jTextField_torque;
    private javax.swing.JTextField jTextField_volFlow;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable table_document;
    private java.awt.TextArea textArea1;
    private javax.swing.JLabel traffic_green;
    private javax.swing.JLabel traffic_orange;
    private javax.swing.JLabel traffic_red;
    private javax.swing.JTextField txt_availability;
    private javax.swing.JTextField txt_availability_total;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_docid;
    private javax.swing.JTextField txt_document;
    private javax.swing.JTextField txt_endValue;
    private javax.swing.JTextField txt_notes;
    private javax.swing.JTextField txt_pr1;
    private javax.swing.JTextField txt_pr2;
    private javax.swing.JTextField txt_pr3;
    private javax.swing.JTextField txt_pressure1_avg;
    private javax.swing.JTextField txt_pressure1_max;
    private javax.swing.JTextField txt_pressure1_min;
    private javax.swing.JTextField txt_pressure2_avg;
    private javax.swing.JTextField txt_pressure2_max;
    private javax.swing.JTextField txt_pressure2_min;
    private javax.swing.JTextField txt_pressure3_avg;
    private javax.swing.JTextField txt_pressure3_max;
    private javax.swing.JTextField txt_pressure3_min;
    private javax.swing.JTextField txt_pumpid;
    private javax.swing.JTextField txt_rot_speed_avg;
    private javax.swing.JTextField txt_rot_speed_max;
    private javax.swing.JTextField txt_rot_speed_min;
    private javax.swing.JTextField txt_rotationalspeed;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_startValue;
    private javax.swing.JTextField txt_temp_avg;
    private javax.swing.JTextField txt_temp_max;
    private javax.swing.JTextField txt_temp_min;
    private javax.swing.JTextField txt_temperature;
    private javax.swing.JTextField txt_torque;
    private javax.swing.JTextField txt_torque_avg;
    private javax.swing.JTextField txt_torque_max;
    private javax.swing.JTextField txt_torque_min;
    private javax.swing.JTextField txt_vol_flow_avg;
    private javax.swing.JTextField txt_vol_flow_max;
    private javax.swing.JTextField txt_vol_flow_min;
    private javax.swing.JTextField txt_volumeflow;
    // End of variables declaration//GEN-END:variables
   
   private int count_p1_intform;
                  private double  divide1,divide2,divide3,divide4,divide5,divide6,divide7;
                  String date1,date2,possibleaction,File_path;
                   double divide_torque=0,divide_rotationalspeed=0,divide_Temperature=0,divide_volumeflow=0,divide_pr1=0,divide_pr2=0,divide_pr3=0,total_availability=0;
}
