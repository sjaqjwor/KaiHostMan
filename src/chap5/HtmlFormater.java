package chap5;

import java.text.Format;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HtmlFormater extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        return "<p>"+logRecord.getMessage()+"</p>";
    }

    @Override
    public String getHead(Handler handler){
        return "<html><head><title>html formatter</title></head><body>";
    }

    @Override
    public String getTail(Handler handler){
        return "</body></html>";
    }

}
