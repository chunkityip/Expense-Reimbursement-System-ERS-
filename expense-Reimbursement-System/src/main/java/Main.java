import io.javalin.Javalin;
import models.ReimbursementsModel;
import models.UsersModel;
import service.FinanceManagerServices;
import service.EmployeeServices;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        Javalin app = Javalin.create().start(4040);
        EmployeeServices usersServices = new EmployeeServices();
        FinanceManagerServices financeManagerServices = new FinanceManagerServices();

        System.out.println("Server listening at part 4040.........");

        /*
        GET - fetch data - SELECT(DAO)
        DELETE - delete data - DELETE(DAO)
        POST - add data - INSERT(DAO)
        PUT - update data - update(DAO)
         */

        //check , check the user
        app.get("/api/checkusers/{users_name}/{password}" , (ctx) -> {
            String userName = ctx.pathParam("users_name");
            String password = ctx.pathParam("password");
            UsersModel checkLogin = usersServices.userLogin(userName, password);
            ctx.json(checkLogin);
        });

        //check , for employee Submit a reimbursement request
        app.post("/api/submit/" , (ctx) -> {
            ReimbursementsModel newcase = ctx.bodyAsClass(ReimbursementsModel.class);
            boolean returnCase = financeManagerServices.addCaseSuccess(newcase);
            ctx.json(returnCase);
        });

        // for Employee Search Their Case Base On Status
        app.get("/api/esbos/{uid}/{statusid}" , (ctx) -> {
            String uid = ctx.pathParam("uid");
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.employeegetList(Integer.parseInt(uid) , Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        //check , for Manager Search Specific Employee
        app.get("/api/msse/{uid}/{statusid}" , (ctx) -> {
            String uid = ctx.pathParam("uid");
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.getAllReimbursement(Integer.parseInt(uid) , Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        //for Manager Search Base On Status
        app.get("/api/msbons/{statusid}" , (ctx) -> {
            String statusid = ctx.pathParam("statusid");
            List<ReimbursementsModel> returnCase = financeManagerServices.getStatusList(Integer.parseInt(statusid));
            ctx.json(returnCase);
        });

        // for Manager Search All Employee
        app.get("/api/msae/" , (ctx) -> {
            List<ReimbursementsModel> returnCase = financeManagerServices.allEmployeeList();
            ctx.json(returnCase);
        });

        // update employee status by manager
        app.put("api/update", (ctx) -> {
            ReimbursementsModel updatecase = ctx.bodyAsClass(ReimbursementsModel.class);
            boolean returnUpdate = financeManagerServices.updateReimbursement(updatecase);
            ctx.json(returnUpdate);
        });


    }
}

