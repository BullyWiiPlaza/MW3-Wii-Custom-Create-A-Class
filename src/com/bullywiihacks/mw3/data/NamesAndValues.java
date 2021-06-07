package com.bullywiihacks.mw3.data;

import java.util.ArrayList;
import java.util.List;

import com.bullywiihacks.mw3.utils.Pair;

public interface NamesAndValues
{
	String[] weaponNames = { "NONE", "USP .45", "MP412", ".44 MAGNUM",
			"DESERT EAGLE", "P99", "FIVE-SEVEN", "ACR 6.8", "TYPE 95", "M4A1",
			"AK-47", "M16A4", "MK14", "G36C", "SCAR-L", "FAD", "CM901", "MP5",
			"PM-9", "P90", "PP90M1", "UMP45", "MP7", "FMG9", "G18", "MP9",
			"SCORPION", "SPAS12", "AA-12", "STRIKER", "MODELL 1887", "USAS12",
			"KSG12", "M60E4", "MK46", "PKP PECHENG", "L86 LSW", "MG36",
			"BARRET .50", "MSR", "RSASS", "DRAGUNOV", "AS50", "L118A", "RPG-7",
			"JAVELIN", "STINGER", "SMAW", "M320 GLM", "RIOT SHIELD", "XM25" };

	String[] weaponValues = { "00", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12",
			"13", "14", "15", "16", "17", "18", "19", "1A", "1C", "1D", "1E",
			"1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"2A", "2B", "2C", "2E", "35", "36", "37", "38", "3F", "42" };

	String[] primaryWeaponNames = { "NONE", "ACR 6.8", "TYPE 95", "M4A1",
			"AK-47", "M16A4", "MK14", "G36C", "SCAR-L", "FAD", "CM901", "MP5",
			"PM-9", "P90", "PP90M1", "UMP45", "MP7", "SPAS12", "AA-12",
			"STRIKER", "MODELL 1887", "USAS12", "KSG12", "M60E4", "MK46",
			"PKP PECHENG", "L86 LSW", "MG36", "BARRET .50", "MSR", "RSASS",
			"DRAGUNOV", "AS50", "L118A", "RIOT SHIELD" };

	String[] primaryWeaponValues = { "00", "07", "08", "09", "0A", "0B", "0C",
			"0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17",
			"1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27",
			"28", "29", "2A", "2B", "2C", "3F" };

	String[] attachmentnamesarray = { "NONE", "RED DOT SIGHT", "ACOG SCOPE",
			"GRIP", "AKIMBO", "THERMAL SCOPE", "SHOTGUN", "HEARTBEAT SENSOR",
			"EXTENDED MAGS", "RAPIDFIRE", "HOLOGRAPHIC SIGHT",
			"TACTICAL KNIFE", "VARIABLE ZOOM", "GRENADE LAUNCHER", "SILENCER",
			"HAMR SCOPE", "HYBRID SIGHT" };

	String[] attachmentvaluesarray = { "00", "01", "02", "03", "04", "05",
			"06", "07", "09", "0A", "0B", "0C", "0D", "10", "11", "14", "15" };

	String[] primaryattachmentnamesarray = { "NONE", "RED DOT SIGHT",
			"ACOG SCOPE", "GRIP", "AKIMBO", "THERMAL SCOPE", "SHOTGUN",
			"HEARTBEAT SENSOR", "EXTENDED MAGS", "RAPIDFIRE",
			"HOLOGRAPHIC SIGHT", "VARIABLE ZOOM", "GRENADE LAUNCHER",
			"SILENCER", "HAMR SCOPE", "HYBRID SIGHT" };

	String[] primaryattachmentvaluesarray = { "00", "01", "02", "03", "04",
			"05", "06", "07", "09", "0A", "0B", "0D", "10", "11", "14", "15" };

	String[] proficiencynamesarray = { "NONE", "TWO ATTACHMENTS", "SPEED",
			"IMPACT", "KICK", "FOCUS", "BREATH", "RANGE", "MELEE", "STABILITY",
			"DAMAGE" };

	String[] proficiencyvaluesarray = { "00", "39", "23", "84", "85", "86",
			"88", "89", "8A", "8B", "8C" };

	String[] camonamesarray = { "NONE", "CLASSIC", "SNOW", "MULTICAM",
			"DIGITAL URBAN", "HEX", "CHOCO", "MARINE", "SNAKE", "WINTER",
			"BLUE", "RED", "AUTUMN", "GOLD" };
	String[] camovaluesarray = { "00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "0A", "0B", "0C", "0D" };

	// Perks
	String[] firstPerkSlot = { "NONE", "RECON", "SLEIGHT OF HAND", "BLIND EYE",
			"EXTREME CONDITIONING", "SCAVENGER" };
	String[] firstPerkSlotValues = { "00", "5C", "0F", "31", "09", "2B" };

	String[] secondperknamesarray = { "NONE", "OVERKILL", "QUICKDRAW",
			"ASSASSIN", "HARDLINE", "BLAST SHIELD" };
	String[] secondperkvaluesarray = { "00", "11", "26", "30", "44", "4E" };

	String[] thirdperknamesarray = { "NONE", "DEAD SILENCE", "SITREP",
			"STEADY AIM", "STALKER", "MARKSMAN" };
	String[] thirdperkvaluesarray = { "00", "08", "0A", "0C", "4A", "94" };

	String[] pointstreaknamesarray = { "NONE", "3 ASSAULT UAV",
			"4 CARE PACKAGE", "5 PREDATOR MISSILE (SPECIALIST)", "5 I.M.S.",
			"5 SENTRY GUN (AIRDROP)", "5 SENTRY GUN", "6 PRECISION AIRSTRIKE",
			"7 ATTACK HELICOPTER", "9 STRAFE RUN", "9 AH6-OVERWATCH",
			"9 REAPER (NOT WORKING)", "10 ASSAULT DRONE (AIRDROP)",
			"10 ASSAULT DRONE", "12 PAVE LOW", "12 AC130 (NOT WORKING)",
			"15 JUGGERNAUT", "17 OSPREY GUNNER (SPECIALIST)", "4 SUPPORT UAV",
			"5 COUNTER UAV", "5 BALLISTIC VESTS", "5 AIRDROP TRAP",
			"8 SAM TURRET", "10 RECON DRONE (NOT WORKING)", "12 ADVANCED UAV",
			"12 REMOTE TURRET", "14 STEALTH BOMBER", "18 EMP",
			"18 JUGGERNAUT RECON", "18 ESCORT AIRDROP",
			"25 M.O.A.B. (ASSAULT DRONE)", "EXTREME CONDITIONING",
			"SLEIGHT OF HAND", "SCAVENGER", "BLIND EYE", "RECON", "HARDLINE",
			"ASSASSIN", "QUICKDRAW", "BLAST SHIELD", "SITREP", "MARKSMAN",
			"STEADY AIM", "DEAD SILENCE", "STALKER" };
	String[] pointstreakvaluesarray = { "00", "01", "02", "03", "04", "05",
			"06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10",
			"12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C",
			"1D", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"2A", "2B", "2C", "2D", "2E", "2F" };

	String[] pointstreakNames = { "NONE", "3 UAV", "4 CARE PACKAGE",
			"5 PREDATOR MISSILE (SPECIALIST)", "5 I.M.S.",
			"5 SENTRY GUN (AIRDROP)", "5 SENTRY GUN", "6 PRECISION AIRSTRIKE",
			"7 ATTACK HELICOPTER", "9 STRAFE RUN", "9 AH6-OVERWATCH",
			"9 REAPER (NOT WORKING)", "10 ASSAULT DRONE (AIRDROP)",
			"10 ASSAULT DRONE", "12 PAVE LOW", "12 AC130 (NOT WORKING)",
			"15 JUGGERNAUT", "17 OSPREY GUNNER (SPECIALIST)", "4 UAV",
			"5 COUNTER UAV", "5 BALLISTIC VESTS", "5 AIRDROP TRAP",
			"8 SAM TURRET", "10 RECON DRONE (NOT WORKING)", "12 ADVANCED UAV",
			"12 REMOTE TURRET", "14 STEALTH BOMBER", "18 EMP",
			"18 JUGGERNAUT RECON", "18 ESCORT AIRDROP",
			"25 M.O.A.B. (ASSAULT DRONE)" };
	String[] pointstreakValues = { "00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "12",
			"13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D",
			"1F", "20" };

	String[] deathstreakNames = { "NONE", "4 JUICED", "4 MARTYRDOM", "4 FINAL STAND",
			"5 REVENGE", "6 DEAD MAN'S HAND", "5 HOLLOW POINTS" };
	String[] deathstreakValues = { "00", "76", "77", "78", "7C", "7D", "7E" };

	String[] equimentNames = { "NONE", "SCRAMBLER", "PORTABLE RADAR", "C4",
			"CLAYMORE", "THROWING KNIFE", "SEMTEX", "FRAG", "BOUNCING BETTY",
			"FLASH GRENADE", "SMOKE GRENADE", "CONCUSSION GRENADE",
			"TROPHY SYSTEM", "EMP GRENADE", "TACTICAL INSERTION" };
	String[] equipmentvaluesarray = { "00", "4B", "4C", "65", "66", "6A", "6B",
			"6C", "6D", "6E", "6F", "70", "72", "75", "83" };

	String[] deadlygrenadesarray = { "NONE", "C4", "CLAYMORE",
			"THROWING KNIFE", "SEMTEX", "FRAG", "BOUNCING BETTY" };
	String[] deadlygrenadevaluesarray = { "00", "65", "66", "6A", "6B", "6C",
			"6D" };
	String[] tacticalgrenadesarray = { "NONE", "SCRAMBLER", "PORTABLE RADAR",
			"FLASH GRENADE", "SMOKE GRENADE", "CONCUSSION GRENADE",
			"TROPHY SYSTEM", "EMP GRENADE", "TACTICAL INSERTION" };
	String[] tacticalgrenadevaluesarray = { "00", "4B", "4C", "6E", "6F", "70",
			"72", "75", "83" };

	String[] reticlenamesarray = { "NONE", "TARGET DOT", "DELTA", "U DOT",
			"MIL DOT", "OMEGA", "LAMBDA" };
	String[] reticlevaluesarray = { "00", "01", "02", "03", "04", "05", "06" };

	String[] strikepackagenamesarray = { "NONE", "ASSAULT", "SUPPORT",
			"SPECIALIST" };
	String[] strikepackagevaluesarray = { "00", "5E", "5F", "61" };

	// ----------

	String[] primaryWeapons = { "NONE", "###ASSAULT RIFLES###", "M4A1",
			"M16A4", "SCAR-L", "CM901", "TYPE 95", "G36C", "ACR 6.8", "MK14",
			"AK-47", "FAD", "###SUBMACHINE GUNS###", "MP5", "UMP45", "PP90M1",
			"P90", "PM-9", "MP7", "###LIGHTMACHINE GUNS###", "L86 LSW", "MG36",
			"PKP PECHENG", "MK46", "M60E4", "###SNIPERS###", "BARRET .50",
			"L118A", "DRAGUNOV", "AS50", "RSASS", "MSR", "###SHOTGUNS###",
			"USAS12", "KSG 12", "SPAS-12", "AA-12", "STRIKER", "MODELL 1887",
			"RIOT SHIELD" };

	List<Pair<String, String>> primWeapons = new ArrayList<>(),
			secWeapons = new ArrayList<>();

	default void fillPrimaryWeapons()
	{
		addDefaultEntries(primWeapons);

		primWeapons.add(new Pair<String, String>("###ASSAULT RIFLES###", null));
		primWeapons.add(new Pair<String, String>("M4A1", "09"));
		primWeapons.add(new Pair<String, String>("M16A4", "09"));
		primWeapons.add(new Pair<String, String>("SCAR-L", "0E"));
		primWeapons.add(new Pair<String, String>("CM901", "10"));
		primWeapons.add(new Pair<String, String>("TYPE 95", "08"));
		primWeapons.add(new Pair<String, String>("G36C", "0D"));
		primWeapons.add(new Pair<String, String>("ACR 6.8", "07"));
		primWeapons.add(new Pair<String, String>("MK14", "0C"));
		primWeapons.add(new Pair<String, String>("AK-47", "0A"));
		primWeapons.add(new Pair<String, String>("FAD", "0F"));

		primWeapons.add(new Pair<String, String>("###SUB MACHINE GUNS###", null));
		primWeapons.add(new Pair<String, String>("MP5", "11"));
		primWeapons.add(new Pair<String, String>("UMP45", "15"));
		primWeapons.add(new Pair<String, String>("PP90M1", "14"));
		primWeapons.add(new Pair<String, String>("P90", "13"));
		primWeapons.add(new Pair<String, String>("PM-9", "12"));
		primWeapons.add(new Pair<String, String>("MP7", "16"));

		primWeapons.add(new Pair<String, String>("###LIGHT MACHINE GUNS###", null));
		primWeapons.add(new Pair<String, String>("L86 LSW", "25"));
		primWeapons.add(new Pair<String, String>("MG36", "26"));
		primWeapons.add(new Pair<String, String>("PKP PECHENG", "24"));
		primWeapons.add(new Pair<String, String>("MK46", "23"));
		primWeapons.add(new Pair<String, String>("M60E4", "22"));

		primWeapons.add(new Pair<String, String>("###SNIPERS###", null));
		primWeapons.add(new Pair<String, String>("BARRET .50", "27"));
		primWeapons.add(new Pair<String, String>("L118A", "2C"));
		primWeapons.add(new Pair<String, String>("DRAGUNOV", "2A"));
		primWeapons.add(new Pair<String, String>("AS50", "2B"));
		primWeapons.add(new Pair<String, String>("RSASS", "29"));
		primWeapons.add(new Pair<String, String>("MSR", "28"));

		primWeapons.add(new Pair<String, String>("###SHOTGUNS###", null));
		primWeapons.add(new Pair<String, String>("USAS12", "20"));
		primWeapons.add(new Pair<String, String>("KSG 12", "21"));
		primWeapons.add(new Pair<String, String>("SPAS-12", "1C"));
		primWeapons.add(new Pair<String, String>("AA-12", "1D"));
		primWeapons.add(new Pair<String, String>("STRIKER", "1E"));
		primWeapons.add(new Pair<String, String>("MODEL 1887", "1F"));

		primWeapons.add(new Pair<String, String>("RIOT SHIELD", "3F"));
	}

	default void fillSecondaryWeapons()
	{
		addDefaultEntries(secWeapons);

		secWeapons.add(new Pair<String, String>("###MACHINE PISTOLS###", null));
		secWeapons.add(new Pair<String, String>("FMG9", "17"));
		secWeapons.add(new Pair<String, String>("MP9", "19"));
		secWeapons.add(new Pair<String, String>("SCORPION", "1A"));
		secWeapons.add(new Pair<String, String>("G18", "18"));

		secWeapons.add(new Pair<String, String>("###PISTOLS###", null));
		secWeapons.add(new Pair<String, String>("USP .45", "01"));
		secWeapons.add(new Pair<String, String>("P99", "05"));
		secWeapons.add(new Pair<String, String>("MP412", "02"));
		secWeapons.add(new Pair<String, String>(".44 MAGNUM", "03"));
		secWeapons.add(new Pair<String, String>("FIVE-SEVEN", "06"));
		secWeapons.add(new Pair<String, String>("DESERT EAGLE", "04"));

		secWeapons.add(new Pair<String, String>("###LAUNCHERS###", null));
		secWeapons.add(new Pair<String, String>("SMAW", "37"));
		secWeapons.add(new Pair<String, String>("JAVELIN", "35"));
		secWeapons.add(new Pair<String, String>("STINGER", "36"));
		secWeapons.add(new Pair<String, String>("XM25", "42"));
		secWeapons.add(new Pair<String, String>("M320 GLM", "38"));
		secWeapons.add(new Pair<String, String>("RPG-7", "2E"));

		secWeapons.add(new Pair<String, String>("###ASSAULT RIFLES###", null));
		secWeapons.add(new Pair<String, String>("M4A1", "09"));
		secWeapons.add(new Pair<String, String>("M16A4", "09"));
		secWeapons.add(new Pair<String, String>("SCAR-L", "0E"));
		secWeapons.add(new Pair<String, String>("CM901", "10"));
		secWeapons.add(new Pair<String, String>("TYPE 95", "08"));
		secWeapons.add(new Pair<String, String>("G36C", "0D"));
		secWeapons.add(new Pair<String, String>("ACR 6.8", "07"));
		secWeapons.add(new Pair<String, String>("MK14", "0C"));
		secWeapons.add(new Pair<String, String>("AK-47", "0A"));
		secWeapons.add(new Pair<String, String>("FAD", "0F"));

		secWeapons.add(new Pair<String, String>("###SUB MACHINE GUNS###", null));
		secWeapons.add(new Pair<String, String>("MP5", "11"));
		secWeapons.add(new Pair<String, String>("UMP45", "15"));
		secWeapons.add(new Pair<String, String>("PP90M1", "14"));
		secWeapons.add(new Pair<String, String>("P90", "13"));
		secWeapons.add(new Pair<String, String>("PM-9", "12"));
		secWeapons.add(new Pair<String, String>("MP7", "16"));

		secWeapons.add(new Pair<String, String>("###LIGHT MACHINE GUNS###", null));
		secWeapons.add(new Pair<String, String>("L86 LSW", "25"));
		secWeapons.add(new Pair<String, String>("MG36", "26"));
		secWeapons.add(new Pair<String, String>("PKP PECHENG", "24"));
		secWeapons.add(new Pair<String, String>("MK46", "23"));
		secWeapons.add(new Pair<String, String>("M60E4", "22"));

		secWeapons.add(new Pair<String, String>("###SNIPERS###", null));
		secWeapons.add(new Pair<String, String>("BARRET .50", "27"));
		secWeapons.add(new Pair<String, String>("L118A", "2C"));
		secWeapons.add(new Pair<String, String>("DRAGUNOV", "2A"));
		secWeapons.add(new Pair<String, String>("AS50", "2B"));
		secWeapons.add(new Pair<String, String>("RSASS", "29"));
		secWeapons.add(new Pair<String, String>("MSR", "28"));

		secWeapons.add(new Pair<String, String>("###SHOTGUNS###", null));
		secWeapons.add(new Pair<String, String>("USAS12", "20"));
		secWeapons.add(new Pair<String, String>("KSG 12", "21"));
		secWeapons.add(new Pair<String, String>("SPAS-12", "1C"));
		secWeapons.add(new Pair<String, String>("AA-12", "1D"));
		secWeapons.add(new Pair<String, String>("STRIKER", "1E"));
		secWeapons.add(new Pair<String, String>("MODEL 1887", "1F"));

		secWeapons.add(new Pair<String, String>("RIOT SHIELD", "3F"));
	}

	default void addDefaultEntries(List<Pair<String, String>> list)
	{
		list.add(new Pair<String, String>("NONE", "00"));
	}

	default boolean assignAll()
	{
		fillPrimaryWeapons();
		fillSecondaryWeapons();

		return true;
	}
}