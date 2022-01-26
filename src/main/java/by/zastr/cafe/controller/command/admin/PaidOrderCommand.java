package by.zastr.cafe.controller.command.admin;

import static by.zastr.cafe.controller.command.RequestParameter.*;

import org.apache.logging.log4j.Level;

import by.zastr.cafe.controller.command.AttributeName;
import by.zastr.cafe.controller.command.Command;
import by.zastr.cafe.controller.command.PagePath;
import by.zastr.cafe.controller.command.Router;
import by.zastr.cafe.controller.command.UserMessage;
import by.zastr.cafe.exception.CommandException;
import by.zastr.cafe.exception.ServiceException;
import by.zastr.cafe.model.service.impl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;


public class PaidOrderCommand implements Command{

	@Override
	public Router execute(HttpServletRequest request) throws CommandException {
		Router router = new Router();
		router.setPagePath(PagePath.ADMIN_ORDERS);
		int orderId = Integer.parseInt(request.getParameter(ORDER_ID));
		OrderServiceImpl orderService = OrderServiceImpl.getInstance();
		try {
			orderService.paid(orderId);
			request.setAttribute(AttributeName.MESSAGE, UserMessage.SUCCESSFUL);
		} catch (ServiceException e) {
			logger.log(Level.ERROR, "Cannot paid order", e);
            throw new CommandException("Cannot paid order", e);
		}

		return router;
	}

}
