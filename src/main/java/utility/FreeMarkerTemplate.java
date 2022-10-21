package utility;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class FreeMarkerTemplate {
    private final Configuration configuration;

    public FreeMarkerTemplate() throws URISyntaxException, IOException {
        this.configuration = new Configuration(Configuration.VERSION_2_3_28){{
            String path = Paths.get(Objects.requireNonNull(FreeMarkerTemplate.class.getResource("/templates")).toURI())
                    .toFile().getAbsolutePath();
            setDirectoryForTemplateLoading(new File(path));
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
