package org.andh.mymybatis.util;

import io.github.cdimascio.dotenv.Dotenv;

public interface DotenvMixin {
    Dotenv dotenv= Dotenv.configure().ignoreIfMissing().load();
}
