import { TestBed } from '@angular/core/testing';

import { AuthentifictionService } from './authentifiction.service';

describe('AuthentifictionService', () => {
  let service: AuthentifictionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthentifictionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
