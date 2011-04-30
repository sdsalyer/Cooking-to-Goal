package com.customfit.ctg.view.recipes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.customfit.ctg.controller.Application;
import com.customfit.ctg.controller.MealPlanner;
import com.customfit.ctg.controller.RecipeManagement;
import com.customfit.ctg.controller.UserManagement;
import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.view.StarRatingTableCellRenderer;
import com.customfit.ctg.view.SubPanel;

/**
 * This is the panel that lists recipes and provides options to interact
 * with the list. This can be used for either browsing or searching.
 *
 * @author Ryan Spoon, David
 */
public class ListRecipesPanel extends SubPanel {

    /**
     * This gets stored whenever the controller passes it this way.
     */
    private List<Recipe> recipes;
    
    /**
     * The Recipe List has two behaviors.
     */
    public static enum ListMode
    {
        LIST_BROWSE,
        LIST_SEARCH
    };
    
    /**
     * This determines the behavior of this list.
     */
    private ListMode listMode;
    
    /** Creates new form ListRecipesPanel */
    public ListRecipesPanel(ListMode listMode) {
        initComponents();
        
        //setup list mode
        this.listMode = listMode;
        
        //customize form for list mode
        if (this.listMode == ListMode.LIST_BROWSE)
            this.jLabelTitle.setText("Manage Recipes");
        else if (this.listMode == ListMode.LIST_SEARCH)
            this.jLabelTitle.setText("Search Recipes");
        
        //setup the me-menu in the right-top corner
        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"User: " + UserManagement.getCurrentUser().getName(), "Profile Home", "Edit Profile", "Logout" }));

        //manually coded (netbeans issue?) on-select event
        jTableRecipes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jTableRecipesValueChanged(evt);
            }
        }
        );
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBoxMeMenu = new javax.swing.JComboBox();
        scrollPaneTable = new javax.swing.JScrollPane();
        jTableRecipes = new javax.swing.JTable();
        linkLabelAddNew = new com.customfit.ctg.view.LinkLabel();
        jButtonEditRecipe = new javax.swing.JButton();
        linkLabelHome = new com.customfit.ctg.view.LinkLabel();
        jButtonDelete = new javax.swing.JButton();
        linkLabelAddToMeal = new com.customfit.ctg.view.LinkLabel();
        jButtonPrint = new javax.swing.JButton();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Recipe Listing");

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("Select a recipe from the list to view the recipe. You may also filter the list by category or ratings.");
        jTextPane1.setFocusable(false);
        jTextPane1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextPane1.setOpaque(false);
        jTextPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextPane1);

        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Me Menu", "Edit User", "Logout" }));
        jComboBoxMeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMeMenuActionPerformed(evt);
            }
        });

        jTableRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRecipes.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableRecipes.getTableHeader().setReorderingAllowed(false);
        jTableRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecipesMouseClicked(evt);
            }
        });
        scrollPaneTable.setViewportView(jTableRecipes);
        jTableRecipes.getColumnModel().getColumn(1).setCellRenderer(new StarRatingTableCellRenderer());

        linkLabelAddNew.setText("Create a new recipe");
        linkLabelAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelAddNewActionPerformed(evt);
            }
        });

        jButtonEditRecipe.setText("Edit");
        jButtonEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditRecipeActionPerformed(evt);
            }
        });

        linkLabelHome.setText("Return to home");
        linkLabelHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelHomeActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        linkLabelAddToMeal.setText("Add to a new meal plan");
        linkLabelAddToMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelAddToMealActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTable)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(linkLabelAddToMeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEditRecipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)
                        .addGap(18, 18, 18)
                        .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkLabelAddToMeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditRecipe)
                    .addComponent(jButtonPrint)
                    .addComponent(jButtonDelete)
                    .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMeMenuActionPerformed
        // process me menu
        
        //if user hit Profile Home
        if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Profile Home"))
            //then tell the controller about it
            UserManagement.viewHome();
        //if user hit Edit User
        else if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Edit Profile"))
            //then tell the controller about it
            UserManagement.editRegistration(UserManagement.getCurrentUser());
        //if user hit Logout
        else if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Logout"))
            //ask controller for logout
            UserManagement.logout();
        //and no matter what, be sure to reset this combo box back to index 0
        this.jComboBoxMeMenu.setSelectedIndex(0);
}//GEN-LAST:event_jComboBoxMeMenuActionPerformed

    private void linkLabelHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelHomeActionPerformed
        //tell controller to go home
        UserManagement.viewHome();
    }//GEN-LAST:event_linkLabelHomeActionPerformed

    private void jButtonEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditRecipeActionPerformed
        //if a row is selected
        if (this.jTableRecipes.getSelectedRowCount() > 0) {
            //grab Recipe
            Recipe recipe = this.recipes.get(this.jTableRecipes.getSelectedRow());
            //tell RecipeManagement to view recipe
            RecipeManagement.editRecipe(recipe);
        }
}//GEN-LAST:event_jButtonEditRecipeActionPerformed

    private void jTableRecipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecipesMouseClicked
        //if double-clicked
        if (evt.getClickCount() == 2)
            //same as view recipe
            jButtonEditRecipeActionPerformed(null);
}//GEN-LAST:event_jTableRecipesMouseClicked

    private void linkLabelAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelAddNewActionPerformed
        //tell controller to create a new recipe
        RecipeManagement.createRecipe();
}//GEN-LAST:event_linkLabelAddNewActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        //if a row is selected
        if (this.jTableRecipes.getSelectedRowCount() > 0)
        {
            //get each selected row
            for (int row : this.jTableRecipes.getSelectedRows())
            {
                //grab Recipe
                Recipe recipe = this.recipes.get(row);
                //tell controller to delete recipe
                RecipeManagement.deleteRecipe(recipe);
                //then refresh
                this.refresh();
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void linkLabelAddToMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelAddToMealActionPerformed
        //if a row is selected
        if (this.jTableRecipes.getSelectedRowCount() > 0) {
            //make a list
            List<Recipe> recipes = new ArrayList<Recipe>();
            //get each selected row
            for (int row : this.jTableRecipes.getSelectedRows())
            {
                //grab Recipe
                Recipe recipe = this.recipes.get(this.jTableRecipes.getSelectedRow());
                //add me to the list
                recipes.add(recipe);
            }
            //then call up the controller for a new panel
            MealPlanner.insertMealPlan(Calendar.getInstance().getTime(), recipes);
        }
}//GEN-LAST:event_linkLabelAddToMealActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        //if a row is selected
        if (this.jTableRecipes.getSelectedRowCount() > 0) {
            //grab Recipe
            Recipe recipe = this.recipes.get(this.jTableRecipes.getSelectedRow());
            //tell RecipeManagement to view recipe
            RecipeManagement.printRecipe(recipe);
        }
    }//GEN-LAST:event_jButtonPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEditRecipe;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRecipes;
    private javax.swing.JTextPane jTextPane1;
    private com.customfit.ctg.view.LinkLabel linkLabelAddNew;
    private com.customfit.ctg.view.LinkLabel linkLabelAddToMeal;
    private com.customfit.ctg.view.LinkLabel linkLabelHome;
    private javax.swing.JScrollPane scrollPaneTable;
    // End of variables declaration//GEN-END:variables

    private void jTableRecipesValueChanged(javax.swing.event.ListSelectionEvent evt) {                                       
        //check for selected value
        if (this.jTableRecipes.getSelectedRowCount() == 0)
        {
            //if none then disable recipe buttons
            this.linkLabelAddToMeal.setVisible(false);
            this.jButtonDelete.setEnabled(false);
            this.jButtonPrint.setEnabled(false);
            this.jButtonEditRecipe.setEnabled(false);
        }
        //otherwise
        else
        {
            //if valid then enable recipe button
            this.linkLabelAddToMeal.setVisible(true);
            this.jButtonDelete.setEnabled(true);
            this.jButtonPrint.setEnabled(true);
            this.jButtonEditRecipe.setEnabled(true);
        }
    } 
    
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
     * Sets the initial list of recipes passed into the view.
     * 
     * @param recipes List of recipes.
     */
    public void setRecipeList(List<Recipe> recipes) {
        this.recipes = recipes;
        
        DefaultTableModel tableModel = (DefaultTableModel)this.jTableRecipes.getModel();
        
        //clear old results
        while (tableModel.getRowCount() > 0)
        {
            tableModel.removeRow(0);
        }

        //add recipes to list
        for (Recipe recipe : recipes)
        {
            Object[] row = {recipe.getName(), recipe.getRating()};
            tableModel.addRow(row);
        }
        
        if (recipes.size() == 0 || this.jTableRecipes.getSelectedRowCount() == 0)
        {
            this.linkLabelAddToMeal.setVisible(false);
            this.jButtonDelete.setEnabled(false);
            this.jButtonPrint.setEnabled(false);
            this.jButtonEditRecipe.setEnabled(false);
        }
        else
        {
            this.linkLabelAddToMeal.setVisible(true);
            this.jButtonDelete.setEnabled(true);
            this.jButtonPrint.setEnabled(true);
            this.jButtonEditRecipe.setEnabled(true);
        }
        
        jTableRecipes.setModel(tableModel);
    }
    
    @Override
    public void refresh()
    {
        //refresh data
        if (this.listMode == ListMode.LIST_BROWSE)
            this.setRecipeList(Application.getDataDriver().selectAllRecipes());
    }

}