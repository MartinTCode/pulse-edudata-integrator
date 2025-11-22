package com.pulse.frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import java.time.LocalDate;

public class InfoTableController {

    @FXML private TableView<StudentRow> infoTableView;
    @FXML private TableColumn<StudentRow, Boolean> rutColumn;
    @FXML private TableColumn<StudentRow, String> namnColumn;
    @FXML private TableColumn<StudentRow, String> omdomeColumn;
    @FXML private TableColumn<StudentRow, String> betygColumn;
    @FXML private TableColumn<StudentRow, LocalDate> exdatumColumn;
    @FXML private TableColumn<StudentRow, String> statusColumn;
    @FXML private TableColumn<StudentRow, String> informationColumn;

    @FXML private Button markeraAllaButton;
    @FXML private Button markeraBetygsattaButton;
    @FXML private Button markeraIngabutton;

    @FXML private DatePicker datumMarkerade;
    @FXML private Button sattDatumButton;

    @FXML private Label antalMarkeradeLabel;

    private final ObservableList<StudentRow> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        infoTableView.setEditable(true);

        namnColumn.setCellValueFactory(c -> c.getValue().namnProperty());
        namnColumn.setEditable(false);

        statusColumn.setCellValueFactory(c -> c.getValue().statusProperty());
        statusColumn.setEditable(false);

        informationColumn.setCellValueFactory(c -> c.getValue().informationProperty());
        informationColumn.setEditable(false);

        // Checkbox column
        rutColumn.setCellValueFactory(c -> c.getValue().selectedProperty());
        rutColumn.setCellFactory(CheckBoxTableCell.forTableColumn(rutColumn));
        rutColumn.setEditable(true);

        // Textcolumns
        
        setupEditableTextColumn(omdomeColumn, StudentRow::omdomeProperty, StudentRow::setOmdome);
        setupEditableTextColumn(betygColumn, StudentRow::betygProperty, StudentRow::setBetyg);

        // DatePicker column
        exdatumColumn.setCellValueFactory(c -> c.getValue().exDatumProperty());
        exdatumColumn.setCellFactory(col -> new DatePickerTableCell<>());
        exdatumColumn.setEditable(true);

        // Add empty data
        infoTableView.setItems(data);

         // Listeners for existing rows
        data.forEach(row ->
            row.selectedProperty().addListener((obs, o, n) -> updateAntalMarkerade())
        );

        // Add Listener for future added rows
        data.addListener((javafx.collections.ListChangeListener.Change<? extends StudentRow> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (StudentRow r : c.getAddedSubList()) {
                        r.selectedProperty().addListener((obs, oldVal, newVal) -> updateAntalMarkerade());
                    }
                }
            }
        });


        // Buttons actions
        markeraAllaButton.setOnAction(e -> data.forEach(row -> row.setSelected(true)));
        markeraIngabutton.setOnAction(e -> data.forEach(row -> row.setSelected(false)));
        markeraBetygsattaButton.setOnAction(e ->
            data.forEach(row -> row.setSelected(!row.getBetyg().isEmpty()))
        );

        // Set date for selected rows
        sattDatumButton.setOnAction(e -> {
            LocalDate d = datumMarkerade.getValue();
            if (d == null) return;

            data.stream()
                .filter(StudentRow::isSelected)
                .forEach(row -> row.setExDatum(d));

            infoTableView.refresh();
        });

        
    }
    // Update label for "antal markerade"
    private void updateAntalMarkerade() {
        long count = data.stream().filter(StudentRow::isSelected).count();
        antalMarkeradeLabel.setText("Antal markerade: " + count);
    }

    //-------------------------
    // Helper methods which setup editable text columns
    //-------------------------

    private void setupEditableTextColumn(
            TableColumn<StudentRow, String> col,
            javafx.util.Callback<StudentRow, javafx.beans.property.StringProperty> prop,
            java.util.function.BiConsumer<StudentRow, String> setter) {

        col.setCellValueFactory(c -> prop.call(c.getValue()));
        col.setCellFactory(TextFieldTableCell.forTableColumn());
        col.setOnEditCommit(e -> setter.accept(e.getRowValue(), e.getNewValue()));
        col.setEditable(true);
    }

    private static class DatePickerTableCell<S> extends TableCell<S, LocalDate> {
        private final DatePicker datePicker = new DatePicker();

        DatePickerTableCell() {
            datePicker.setOnAction(e -> commitEdit(datePicker.getValue()));
            setGraphic(datePicker);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }

        @Override
        public void startEdit() {
            super.startEdit();
            datePicker.setValue(getItem());
            datePicker.requestFocus();
            datePicker.show();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(getItem() == null ? "" : getItem().toString());
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void commitEdit(LocalDate newValue) {
            super.commitEdit(newValue);

            StudentRow row = (StudentRow) getTableRow().getItem();
            if (row != null) row.setExDatum(newValue);

            setText(newValue == null ? "" : newValue.toString());
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        protected void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                if (isEditing()) {
                    datePicker.setValue(item);
                    setGraphic(datePicker);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setGraphic(null);
                    setText(item == null ? "" : item.toString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }
    }
}
