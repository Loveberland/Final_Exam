package Final_Exam.display;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class DialogBox extends JPanel {

    private java.util.List<java.util.List<String>> dialogSets;
    private int currentSet = 0;
    private int currentLine = 0;


    public DialogBox() {
        setOpaque(false);
        setPreferredSize(new Dimension(600, 200));
        setBackground(new Color(0,0,0,0)); // โปร่งใส

        dialogSets = new ArrayList<>();

        dialogSets.add(Arrays.asList(
                "ในวันเปิดภาคเรียน นักศึกษาหนุ่มคนหนึ่งก้าวเข้าสู่มหาวิทยาลัยชั้นนำของประเทศ สถานที่ซึ่งขึ้นชื่อว่า \"สร้างอัจฉริยะ\" และ \"กลืนกินคนอ่อนแอ\"\n" +
                        "ไปพร้อมกัน เขาเลือกสาขาวิชาที่ไม่มีอยู่ในหลักสูตรทั่วไป สาขาที่ถูกระบุไว้เพียงว่า \"สาขาวิชาพิเศษ\" โดยไม่มีคำอธิบายใดเพิ่มเติม ทันทีที่ประตู\n" +
                        "มหาวิทยาลัยปิดลง ม่านหมอกพิษสีหม่นก็แผ่ ขยายออกมา กลืนกินโลกภายนอกจนไม่เหลือแม้แต่สัญญาณการสื่อสาร ผู้ที่พยายามหลบหนี ล้มตาย ผู้\n",
                "ที่พยายามต่อต้าน หายสาบสูญ และผู้ที่ยอมจำนน... ค่อย ๆ สูญเสียความเป็นมนุษย์ นักศึกษาค้นพบความจริงอันโหดร้าย ที่นี่ไม่ใช่สถานศึกษา\n" +
                        "แต่คือสนามทดลอง ความรู้ไม่ใช่เครื่องมือเพื่อพัฒนา แต่คือ อาวุธ เกรดไม่ใช่ตัวชี้วัดความ สามารถ แต่คือ เส้นแบ่งระหว่างชีวิตและความตาย",
                "เหนือมหาวิทยาลัยแห่งนี้ มี \"ผู้ปกครอง\" ปกครองอยู่ แต่ละคนครอบครองศาสตร์ ต้องห้าม แข็งแกร่งเกินกว่านักศึกษาจะต่อต้านได้ พวกเขาควบคุม\n" +
                        "หลักสูตร บิดเบือนความ จริง และคัดเลือกเฉพาะผู้ที่ \"เหมาะสมจะรอด\"",
                "ท่ามกลางความสิ้นหวัง มีตำนานต้องห้ามถูกกระซิบต่อกันในหมู่นักศึกษาเงามืด \"หากผู้ใดมีจิตใจที่ไม่แตกสลาย มีสติปัญญาที่ไม่ยอมศิโรราบ และ\n" +
                        "สามารถโค่นล้มผู้ ปกครองทั้งหมดลงได้ ม่านหมอกจะจางหาย และประตูสู่โลกภายนอกจะเปิดอีกครั้ง\""
        ));

        String text = dialogSets.get(currentSet).get(currentLine);

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {

                if (SwingUtilities.isLeftMouseButton(e)) {
                    nextDialogSet();
                }
            }
        });
    }

    private void drawWrappedText(Graphics2D g2, String text, int x, int y, int maxWidth) {

        FontMetrics fm = g2.getFontMetrics();
        String[] words = text.split(" ");

        String line = "";
        int lineHeight = fm.getHeight();

        for (String word : words) {

            String testLine = line + word + " ";
            int testWidth = fm.stringWidth(testLine);

            if (testWidth > maxWidth) {
                g2.drawString(line, x, y);
                line = word + " ";
                y += lineHeight;
            } else {

                line = testLine;

            }
        }

        // draw last line
        g2.drawString(line, x, y);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // smooth text
        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        // Background
        g2.setColor(new Color(22, 52, 217, 129));
        g2.fillRoundRect(20, 20, 560, 180, 20, 20);

        // Border
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(20, 20, 560, 180, 20, 20);

        // Font
        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.setColor(Color.WHITE);

        if (dialogSets.size() > 0) {
            String text = dialogSets.get(currentSet).get(currentLine);
            // use wrap
            drawWrappedText(g2, text, 40, 50, 500);
        }
        // Arrow
        g2.setFont(new Font("Arial", Font.BOLD, 24));
//        g2.drawString("▶", 540, 140);
    }

    public void setDialogSets(java.util.List<java.util.List<String>> dialogSets) {
        this.dialogSets = dialogSets;
        currentSet = 0;
        currentLine = 0;
        repaint();
    }


    private void nextDialogSet() {
        currentLine++;
        if (currentLine >= dialogSets.get(currentSet).size()) {
            currentLine = 0;
            currentSet++;
            if (currentSet >= dialogSets.size()) {
                currentSet = dialogSets.size() - 1;
            }
        }
        repaint();
    }
}
