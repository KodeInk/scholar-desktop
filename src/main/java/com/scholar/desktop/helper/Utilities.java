/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.helper;

import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.ws.Response;
import main.java.com.scholar.desktop.engine.caller.api.v1.studyyear.response.StudyYearResponse;
import main.java.com.scholar.desktop.helper.exceptions.Message;

/**
 *
 * @author mover 2/9/2018
 */
public class Utilities {

    private static final Logger LOG = Logger.getLogger(Utilities.class.getName());

    public static final Integer default_offset = 0;
    public static final Integer default_limit = 20;
    private static JDialog dialog;
    private final static String DATE_FORMAT = "dd MMM, yyyy";

    public static void throwAndReturnSanizedErrorMessages(Response response) {

    }

    public static String getParameterForLogging(Map parameter) {
        try {

            return "none";

        } catch (Exception ex) {
            return "--- parameter conversion error ---";
        }
    }

    public static void logParameters(String message, Map parameter, String logId) {
        String parameterLog = getParameterForLogging(parameter);
        if (parameterLog.charAt(0) == '-') {
            LOG.log(Level.SEVERE, "{0} :: log parameters failed", logId);
        } else {
            LOG.log(Level.INFO, "{0} :: {1}: {2}", new Object[]{logId, message, parameterLog});
        }
    }

    public static void ShowAlertMessage(javax.ws.rs.core.Response response) throws HeadlessException {
        Message message = response.readEntity(Message.class);
        JOptionPane.showMessageDialog(null, message.getMessage());
    }

    public static Integer getOffset(Integer offset) {
        if (offset == null) {
            offset = default_offset;
        }
        return offset;

    }

    public static Integer getLimit(Integer limit) {
        if (limit == null) {
            limit = default_offset;
        }
        return limit;

    }

    /**
     *
     * @param defaultTableModel
     */
    public static void removeRowsFromDefaultModel(DefaultTableModel defaultTableModel) {
        if (defaultTableModel.getRowCount() > 0) {
            for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
                defaultTableModel.removeRow(i);
            }
        }
    }

    public static void ShowDialogMessage(String message) {

        if (dialog == null) {
            dialog = new JDialog();
        }
        hideDialog();

        JLabel jl = initDialogJLabel(message);

        dialog.add(BorderLayout.CENTER, jl);

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        dialog.setVisible(true);
    }

    public static JLabel initDialogJLabel(String message) {
        JLabel jl = new JLabel();
        jl.setFont(new java.awt.Font("Arial", 1, 18));
        jl.setText(message);
        jl.setAlignmentX(CENTER_ALIGNMENT);
        return jl;
    }

    public static void hideDialog() {
        if (dialog != null) {
            dialog.setVisible(false);
        }
    }

    public static Date toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(tz);
        return fromISO8601UTC(df.format(date));
    }

    public static Date fromISO8601UTC(String dateStr) {
        TimeZone tz = TimeZone.getTimeZone("UTC");

        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(tz);

        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String toISO8601Local(Date date) {
        TimeZone tz = TimeZone.getDefault();
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(tz);
        return df.format(date);
    }

    public static Date fromISO8601Local(String dateStr) {
        TimeZone tz = TimeZone.getDefault();

        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setTimeZone(tz);

        try {
            return df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void hideColumn(Integer columnIndex, JTable jTable) {
        TableColumn tc = jTable.getColumnModel().getColumn(columnIndex);
        jTable.removeColumn(tc);
    }

    public static String getSimpleDate(Long longDate) {
        if (longDate != null) {
            Date date = new Date(longDate);
            SimpleDateFormat df2 = new SimpleDateFormat(DATE_FORMAT);
            String start_date = df2.format(date);
            return start_date;
        }
        return "-";
    }

}
