package utility;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class FreeMarkerTemplate {
    private final Configuration configuration;

    public FreeMarkerTemplate(){
        this.configuration = new Configuration(Configuration.VERSION_2_3_28){{
            setClassForTemplateLoading(this.getClass(), "/templates");
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    public void render(String templateFile, Map<String, Object> data, HttpServletResponse rs) throws IOException {
        try {
            rs.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
            configuration.getTemplate(templateFile).process(data, rs.getWriter());
        } catch (TemplateException ex) {
            ex.printStackTrace();
        }
    }
}
