package math.combine;

import java.util.ArrayList;

/**
 * 递归找出所有可能的球队组合
 */
public class TeamCombine {
	/**
	 *
	 * @param m			选出的球队数
	 * @param teams		总球队数
	 * @param result	球队组合结果
	 */
	public static void combine(int m, ArrayList<String> teams, ArrayList<String> result) {
		//选出m个球队就输出结果
		if (result.size() == m) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < teams.size(); i++) {
			//从剩下的队伍中选择一队, 加入结果
			ArrayList<String> newResult = (ArrayList<String>)result.clone();
			newResult.add(teams.get(i));

			//只考虑当前选择之后的所有队伍
			ArrayList<String> newTeams = (ArrayList<String>) teams.subList(i+1, teams.size());

			//递归, 对剩余的球队继续生产组合
			combine(m, newTeams, newResult);
		}
	}
}
