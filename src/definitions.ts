export interface DontKillMyAppPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
