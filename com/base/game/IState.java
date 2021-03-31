package com.base.game;

public interface IState {
	public void Update(float elapsedTime);
	public void Render();
	public void OnEnter();
	public void OnExit();
}
