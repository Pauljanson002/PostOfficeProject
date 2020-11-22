let $ = window.jQuery;
export default class EmployeeController{
    addClickHandler(){
        this.$element = $('[data-sidebar-employees="click"]');
        this.$element.on('click',(event)=>{
            event.preventDefault();
            $('[data-content="center"]').load("tables.html",()=>{
                $("#dataTable").DataTable();
            });

        })
    }
}