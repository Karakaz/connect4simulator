package io.karakaz.connect4simulator.db.fetchers;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TableStateFetcher_Factory implements Factory<TableStateFetcher> {
  private static final TableStateFetcher_Factory INSTANCE = new TableStateFetcher_Factory();

  @Override
  public TableStateFetcher get() {
    return new TableStateFetcher();
  }

  public static Factory<TableStateFetcher> create() {
    return INSTANCE;
  }

  public static TableStateFetcher newTableStateFetcher() {
    return new TableStateFetcher();
  }
}
