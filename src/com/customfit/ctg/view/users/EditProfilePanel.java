package com.customfit.ctg.view.users;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.customfit.ctg.controller.Application;
import com.customfit.ctg.controller.UserManagement;
import com.customfit.ctg.model.GoalDirection;
import com.customfit.ctg.model.Meal;
import com.customfit.ctg.model.Measurement;
import com.customfit.ctg.model.Member;
import com.customfit.ctg.model.NutritionFacts;
import com.customfit.ctg.model.User;
import com.customfit.ctg.view.CreateEditMode;
import com.customfit.ctg.view.CreateEditPanel;

/**
 * Presents the user with a way to edit their user profile.
 * 
 * @author David
 */
public class EditProfilePanel extends CreateEditPanel {

    /**
     * The user currently displayed on the panel.
     */
    private User user;
    
    /** Creates new form OldEditAccountPanel */
    public EditProfilePanel(CreateEditMode createEditMode) {
        initComponents();
        
        this.setCreateEditMode(createEditMode);
        
        //fix the form for creation mode when selected at instantiation
        if (createEditMode == CreateEditMode.CREATE)
        {
            this.jLabelTitle.setText("Register a New User");
            this.jTextPaneInstructions.setText("Please complete the following information in order to register a new user.\n\n" +  this.jTextPaneInstructions.getText());
            this.jButtonSave.setText("Register User");
            this.linkLabelDelete.setVisible(false);
        }
        
        //add the proper nutrients to the drop down
        this.jComboBoxTargetNutrient.removeAllItems();
        for (String nutrient: NutritionFacts.getAllValidNutrients())
        {
            this.jComboBoxTargetNutrient.addItem(nutrient);
        }
        
        //listen for member table events
        DefaultTableModel dtm = (DefaultTableModel)jTableMembers.getModel();
        dtm.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                DefaultTableModel membersModel = (DefaultTableModel) jTableMembers.getModel();
                //if column is Member
                if (e.getColumn() == 0)
                {
                    //check for name identical to this one
                    for (int row = e.getFirstRow(); row <= e.getLastRow(); row++)
                        if (((String)membersModel.getValueAt(row, e.getColumn())).trim().equals(jTextFieldUser.getText()) ||
                                ((String)membersModel.getValueAt(row, e.getColumn())).trim().equals("") ||
                                    (getCreateEditMode() == CreateEditMode.EDIT &&
                                    ((String)membersModel.getValueAt(row, e.getColumn())).trim().equals(user.getName())))
                            membersModel.setValueAt("Member's Name", row, e.getColumn());
                }
                //else if column is Target
                else if (e.getColumn() == 1)
                {
                    //then make sure we insert the right unit on each one
                    for (int row = e.getFirstRow(); row <= e.getLastRow(); row++)
                    {
                        Measurement measurement = new Measurement((String)membersModel.getValueAt(row, e.getColumn()));
                        measurement.setUnit(NutritionFacts.getUnitForNutrient((String)jComboBoxTargetNutrient.getSelectedItem()));
                        if (!measurement.toString().equals((String)membersModel.getValueAt(row, e.getColumn())))
                            membersModel.setValueAt(measurement.toString(), row, e.getColumn());
                    }
                }
                validateForm();
            }
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDirection = new javax.swing.ButtonGroup();
        jLabelTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        linkLabelDelete = new com.customfit.ctg.view.LinkLabel();
        jRadioButtonMaximumDirection = new javax.swing.JRadioButton();
        jRadioButtonMinimumDirection = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        scrollPaneIngedients = new javax.swing.JScrollPane();
        jTableMembers = new javax.swing.JTable();
        jButtonAddMember = new javax.swing.JButton();
        jButtonRemoveMember = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTargetAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTargetNutrient = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneInstructions = new javax.swing.JTextPane();
        jLabelNutrientUnit = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(575, 345));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Edit Profile");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Your Name:");

        jTextFieldUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUserKeyReleased(evt);
            }
        });

        jButtonSave.setText("Save Profile");
        jButtonSave.setEnabled(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        linkLabelDelete.setText("I want to delete my user profile.");
        linkLabelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelDeleteActionPerformed(evt);
            }
        });

        buttonGroupDirection.add(jRadioButtonMaximumDirection);
        jRadioButtonMaximumDirection.setText("Maximum Amount");
        jRadioButtonMaximumDirection.setActionCommand("Maximum");
        jRadioButtonMaximumDirection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMaximumDirectionActionPerformed(evt);
            }
        });

        buttonGroupDirection.add(jRadioButtonMinimumDirection);
        jRadioButtonMinimumDirection.setText("Minimum Amount");
        jRadioButtonMinimumDirection.setActionCommand("Minimum");
        jRadioButtonMinimumDirection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMinimumDirectionActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional members to track", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member", "Targeted Nutrient Amount Per Day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableMembers.setCellSelectionEnabled(true);
        jTableMembers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableMembers.getTableHeader().setReorderingAllowed(false);
        scrollPaneIngedients.setViewportView(jTableMembers);

        jButtonAddMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/add-item.png"))); // NOI18N
        jButtonAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMemberActionPerformed(evt);
            }
        });

        jButtonRemoveMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/subtract-item.png"))); // NOI18N
        jButtonRemoveMember.setDefaultCapable(false);
        jButtonRemoveMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonAddMember, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoveMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(482, Short.MAX_VALUE))
            .addComponent(scrollPaneIngedients, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRemoveMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneIngedients, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Targeted Nutrient:");

        jTextFieldTargetAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTargetAmountKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("per day");

        jComboBoxTargetNutrient.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Calories", "Fat", "Sodium" }));
        jComboBoxTargetNutrient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTargetNutrientActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        jTextPaneInstructions.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPaneInstructions.setBorder(null);
        jTextPaneInstructions.setEditable(false);
        jTextPaneInstructions.setText("Please enter your name and your nutritional goals. You may specify a minimum goal or a maximum goal.  This will affect your meal portioning sizes and other calculations.");
        jTextPaneInstructions.setFocusable(false);
        jTextPaneInstructions.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextPaneInstructions.setOpaque(false);
        jTextPaneInstructions.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextPaneInstructions);

        jLabelNutrientUnit.setText("units");

        jScrollPane3.setBorder(null);

        jTextPane2.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane2.setBorder(null);
        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jTextPane2.setText("Would you like to scale your weekly menu based on a maximum or minimum nutritional amount?");
        jTextPane2.setFocusable(false);
        jTextPane2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextPane2.setOpaque(false);
        jTextPane2.setVerifyInputWhenFocusTarget(false);
        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                            .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButtonMaximumDirection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonMinimumDirection)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel)
                        .addGap(18, 18, 18)
                        .addComponent(linkLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jComboBoxTargetNutrient, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTargetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNutrientUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonMaximumDirection)
                    .addComponent(jRadioButtonMinimumDirection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTargetNutrient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTargetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNutrientUnit)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel)
                    .addComponent(linkLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUserKeyReleased
        this.validateForm();
}//GEN-LAST:event_jTextFieldUserKeyReleased

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (this.getCreateEditMode() == CreateEditMode.EDIT)
        {
            //keep the previous user name
            String previousUserName = this.user.getName();
            //update the user
            this.user.setName(this.jTextFieldUser.getText());
            //update user and present previous panel
            UserManagement.updateRegistrationAndGoBack(previousUserName, this.getUser());
        }
        else if (this.getCreateEditMode() == CreateEditMode.CREATE)
        {
            //register user and present login
            UserManagement.registerUserAndPresentLogin(this.getUser());
        }
}//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        //user bailed out, go back to the last panel
        Application.getMainFrame().goBack();
}//GEN-LAST:event_jButtonCancelActionPerformed

    private void linkLabelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelDeleteActionPerformed
        //tell controller to process delete request
        UserManagement.deleteUser(this.user.getName());
    }//GEN-LAST:event_linkLabelDeleteActionPerformed

    private void jButtonAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMemberActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTableMembers.getModel();
        dtm.addRow(new Object [] {"Member's Name", "0.0 " + NutritionFacts.getUnitForNutrient((String)jComboBoxTargetNutrient.getSelectedItem())});
}//GEN-LAST:event_jButtonAddMemberActionPerformed

    private void jButtonRemoveMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveMemberActionPerformed
        int currentRow = jTableMembers.getSelectedRow();
        if (currentRow != -1) {
            DefaultTableModel dtm = (DefaultTableModel)jTableMembers.getModel();
            dtm.removeRow(currentRow);
            if (currentRow < jTableMembers.getRowCount())
                jTableMembers.setRowSelectionInterval(currentRow, currentRow);
        }
}//GEN-LAST:event_jButtonRemoveMemberActionPerformed

    private void jTextFieldTargetAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTargetAmountKeyReleased
        this.validateForm();
    }//GEN-LAST:event_jTextFieldTargetAmountKeyReleased

    private void jComboBoxTargetNutrientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTargetNutrientActionPerformed
        if (this.jComboBoxTargetNutrient.getItemCount() > 0 && this.jComboBoxTargetNutrient.getSelectedItem() != null)
        {
            String newUnit = NutritionFacts.getUnitForNutrient((String)this.jComboBoxTargetNutrient.getSelectedItem());
            //update unit for the nutrient
            this.jLabelNutrientUnit.setText(newUnit);
            //update unit for every member
            for (int memberRow = 0; memberRow < this.jTableMembers.getModel().getRowCount(); memberRow++)
            {
                Measurement measurement = new Measurement((String)this.jTableMembers.getModel().getValueAt(0, 1));
                measurement.setUnit(newUnit);
                this.jTableMembers.getModel().setValueAt(measurement.toString(), memberRow, 1);
            }
        }
        this.validateForm();
    }//GEN-LAST:event_jComboBoxTargetNutrientActionPerformed

    private void jRadioButtonMaximumDirectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMaximumDirectionActionPerformed
        this.validateForm();
    }//GEN-LAST:event_jRadioButtonMaximumDirectionActionPerformed

    private void jRadioButtonMinimumDirectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMinimumDirectionActionPerformed
        this.validateForm();
    }//GEN-LAST:event_jRadioButtonMinimumDirectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDirection;
    private javax.swing.JButton jButtonAddMember;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonRemoveMember;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxTargetNutrient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNutrientUnit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonMaximumDirection;
    private javax.swing.JRadioButton jRadioButtonMinimumDirection;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableMembers;
    private javax.swing.JTextField jTextFieldTargetAmount;
    private javax.swing.JTextField jTextFieldUser;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPaneInstructions;
    private com.customfit.ctg.view.LinkLabel linkLabelDelete;
    private javax.swing.JScrollPane scrollPaneIngedients;
    // End of variables declaration//GEN-END:variables

    /**
     * Extends SubPanel functionality by returning the title as being the
     * same as on the panel itself.
     * @return The title in the panel.
     */
    @Override
    public String getTitle()
    {
        //grab title from on the panel
        return this.jLabelTitle.getText();
    }
    
    /**
     * Sets the User for which the form will be laid out.
     * @param user 
     */
    public void setUser(User user) {
        //store user
        this.user = user;
        //set user name box
        this.jTextFieldUser.setText(user.getName());
        //set the min/max radio
        Enumeration<AbstractButton> directionButtons = this.buttonGroupDirection.getElements();
        while (directionButtons.hasMoreElements())
        {
            AbstractButton buttonDirection = directionButtons.nextElement();
            if (buttonDirection.getActionCommand().equals("Maximum")
                    && this.user.getOwnMember().getGoalDirection() == GoalDirection.MAXIMUM_GOAL)
            {
                this.buttonGroupDirection.setSelected(buttonDirection.getModel(), true);
            }
            else if (buttonDirection.getActionCommand().equals("Minimum")
                    && this.user.getOwnMember().getGoalDirection() == GoalDirection.MINIMUM_GOAL)
            {
                this.buttonGroupDirection.setSelected(buttonDirection.getModel(), true);
            }
        }
        //set targeted nutrient
        for (int n = 0; n < this.jComboBoxTargetNutrient.getItemCount(); n++)
        {
            if (((String)this.jComboBoxTargetNutrient.getItemAt(n)).equals(user.getTrackedNutrient()))
                this.jComboBoxTargetNutrient.setSelectedIndex(n);
        }
        //set own nutrient information
        Member ownMember = user.getOwnMember();
        this.jTextFieldTargetAmount.setText(Double.valueOf(ownMember.getGoal().getQuantity()).toString());
        this.jLabelNutrientUnit.setText(ownMember.getGoal().getUnit());
        this.jComboBoxTargetNutrient.setSelectedItem(user.getTrackedNutrient());
        //set other member targets
        DefaultTableModel membersTableModel = (DefaultTableModel) this.jTableMembers.getModel();
        for (Member member : user.getAllOtherMembers())
        {
            membersTableModel.addRow(new Object[]{
                member.getName(), member.getGoal().toString()
            });
        }
    }
    
    /**
     * Generates a User object based on the form data.
     * 
     * @param user User made from the form data.
     */
    public User getUser()
    {
        ArrayList<Member> members = new ArrayList<Member>();
        {
            //build user's member
            String memberName = this.jTextFieldUser.getText();
            Double amount = Double.parseDouble(this.jTextFieldTargetAmount.getText());
            Measurement goal = new Measurement(amount, NutritionFacts.getUnitForNutrient((String)jComboBoxTargetNutrient.getSelectedItem()));
            if (this.buttonGroupDirection.getSelection().getActionCommand().equals("Maximum"))
                members.add(new Member(memberName,
                        (String)this.jComboBoxTargetNutrient.getSelectedItem(),
                        goal,
                        GoalDirection.MAXIMUM_GOAL));
            else if (this.buttonGroupDirection.getSelection().getActionCommand().equals("Minimum"))
                members.add(new Member(memberName,
                        (String)this.jComboBoxTargetNutrient.getSelectedItem(),
                        goal,
                        GoalDirection.MINIMUM_GOAL));
        }
        for (int memberRow = 0; memberRow < this.jTableMembers.getModel().getRowCount(); memberRow++)
        {
            //build all other members
            String memberName = (String)this.jTableMembers.getModel().getValueAt(memberRow, 0);
            String amount = (String)this.jTableMembers.getModel().getValueAt(memberRow, 1);
            Measurement goal = new Measurement(amount);
            ButtonModel model = (ButtonModel)this.buttonGroupDirection.getSelection();
            if (model.getActionCommand().equals("Maximum"))
                members.add(new Member(memberName,
                        (String)this.jComboBoxTargetNutrient.getSelectedItem(),
                        goal,
                        GoalDirection.MAXIMUM_GOAL));
            else if (model.getActionCommand().equals("Minimum"))
                members.add(new Member(memberName,
                        (String)this.jComboBoxTargetNutrient.getSelectedItem(),
                        goal,
                        GoalDirection.MINIMUM_GOAL));
        }
        if (this.getCreateEditMode() == CreateEditMode.CREATE)
            //create a new user
            return new User(
                    this.jTextFieldUser.getText(),
                    members,
                    new ArrayList<Meal>()
                    );
        else if (this.getCreateEditMode() == CreateEditMode.EDIT)
            //create a new user from the existing user (i.e., keep meals)
            return new User(
                    this.jTextFieldUser.getText(),
                    members,
                    this.user.getAllMeals()
                    );
        else
            return null;
    }
    
    /**
     * Makes sure we are good to save before actually enabling the save button.
     */
    private void validateForm()
    {
        boolean disableSaves = false;
        if (this.jTextFieldUser.getText().trim().length() <= 2)
            disableSaves = true;
        else if (this.buttonGroupDirection.getSelection() == null)
            disableSaves = true;
        else if (this.jTextFieldTargetAmount.getText().trim().isEmpty())
            disableSaves = true;
        else if (this.getCreateEditMode() == CreateEditMode.EDIT && this.user.equals(this.getUser()))
            disableSaves = true;
        this.jButtonSave.setEnabled(!disableSaves);
    }
}
