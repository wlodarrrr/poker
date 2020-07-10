package gui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route("")
@Push
@PWA(name = "Project Base for Vaadin", shortName = "Project Base", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends HorizontalLayout {

	private final ChatView chatView;
	private final LoginView loginView;
	private final TableView tableView;
	private String name;

	public MainView() {
		setSizeFull();
		addClassName("centered");
		loginView = new LoginView(this);
		chatView = new ChatView(this);
		tableView = new TableView(this);

		add(new HorizontalLayout(new VerticalLayout(loginView, chatView), tableView));

		chatView.setVisible(false);
		tableView.setVisible(false);

	}

	public String getName() {
		return name;
	}

	public void login(String name) {
		this.name = name;
		loginView.login();

		chatView.setVisible(true);
		chatView.register();

		tableView.setVisible(true);
		tableView.join();

	}

	public void logout() {
		loginView.logout();

		chatView.deregister();
		chatView.setVisible(false);

		tableView.setVisible(false);

	}
}
