public class ParametersBag
{
    public ParametersBag(String args[])
    {
        // указанная папка не существует, не передан лимит и т.п.
        throw new IllegalArgumentException("Не указан путь в папке");


    }

    public long getLimit()
    {
        return 0;
    }

    public String getPath()
    {
        return "";
    }
}
