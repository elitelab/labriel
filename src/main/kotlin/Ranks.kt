package io.runelab

enum class Ranks(val requirement: Long, val roleId: Long) {
    Bronze(1, 1261417845024096368),
    Iron(250, 1261412908986794045),
    Steel(500, 1261413781465206805),
    Mithril(1_000, 1261413853107978352),
    Adamant(2_500, 1261413896971878471),
    Rune(5_000, 1261413919671582720),
    Dragon(10_000, 1261413951380394076),
    Torva(25_000, 1261420188826341377)
}
