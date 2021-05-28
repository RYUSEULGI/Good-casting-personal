import React, { useCallback } from 'react';
import { Select } from '../Core';

const defaultYear = [
    { value: '0', label: '연도선택', name: 'year' },
    { value: '2021', label: '2021년', name: 'year' },
    { value: '2020', label: '2020년', name: 'year' },
    { value: '2019', label: '2019년', name: 'year' },
    { value: '2018', label: '2018년', name: 'year' },
    { value: '2017', label: '2017년', name: 'year' },
    { value: '2016', label: '2016년', name: 'year' },
    { value: '2015', label: '2015년', name: 'year' },
    { value: '2014', label: '2014년', name: 'year' },
    { value: '2013', label: '2013년', name: 'year' },
    { value: '2012', label: '2012년', name: 'year' },
    { value: '2011', label: '2011년 이전', name: 'year' },
];

const defaultGerne = [
    { value: '0', label: '작품유형', name: 'gerne' },
    { value: 'drama', label: '드라마', name: 'gerne' },
    { value: 'movie', label: '영화', name: 'gerne' },
    { value: 'webDrama', label: '웹드라마', name: 'gerne' },
    { value: 'play', label: '공연', name: 'gerne' },
];

const ProfileCareer = () => {
    const handleChagne = useCallback((e) => {
        console.log('클릭');
    }, []);
    return (
        <>
            <div class="box_full">
                <div class="tit_sub v2">출연작품</div>
                <div class="box_top_area">
                    <div class="input-group tit_group">
                        <div class="input-group-prepend wp16">
                            <div>참여연도</div>
                        </div>
                        <div class="input-group-prepend wp16">
                            <div>작품유형</div>
                        </div>
                        <div class="input-group-prepend wp32">
                            <div>작품명</div>
                        </div>
                        <div class="input-group-append">
                            <div>내용</div>
                        </div>
                    </div>
                </div>

                <div class="box_list_area career_list">
                    <div class="input-group">
                        <button
                            class="btn btn-black md w-100"
                            type="button"
                            onClick="funcAddElement('career')"
                        >
                            <i class="add"></i>추가
                        </button>
                    </div>
                </div>
            </div>

            {/* <div class="tit_sub v2">수상내역</div>
            <div class="box_top_area">
                <div class="input-group tit_group">
                    <div class="input-group-prepend wp16">
                        <div>수상연도</div>
                    </div>
                    <div class="input-group-prepend wp32">
                        <div>수여기관</div>
                    </div>
                    <div class="input-group-append">
                        <div>수여내용</div>
                    </div>
                </div>
            </div>

            <div class="box_list_area prize_list">
                <div class="input-group">
                    <button
                        class="btn btn-black md w-100"
                        type="button"
                        onClick="funcAddElement('prize')"
                    >
                        <i class="prize"></i>
                        <i class="add"></i>추가
                    </button>
                </div>
            </div> */}

            <div id="temp_career">
                <div class="input-group career_item">
                    <input type="hidden" name="careerTypeArr" value="C" />
                    <div class="input-group-prepend wp16">
                        <Select
                            className="form-control pl-0 arrow-3 w-100 font-size-4 d-flex align-items-center w-100 "
                            boarder={false}
                            options={defaultYear}
                            onChange={handleChagne}
                        />
                    </div>

                    <div class="input-group-prepend wp16">
                        <Select
                            className="form-control pl-0 arrow-3 w-100 font-size-4 d-flex align-items-center w-100 "
                            boarder={false}
                            options={defaultGerne}
                            onChange={handleChagne}
                        />
                    </div>

                    <div class="input-group-prepend wp32">
                        <input
                            type="text"
                            maxLength="20"
                            name="broadNameArr"
                            class="form-control  broadName"
                            placeholder="방송사 입력"
                        />
                        <input
                            type="text"
                            maxLength="120"
                            name="careerNameArr"
                            class="form-control careerName"
                            placeholder="작품명 입력"
                            readOnly
                        />
                    </div>
                    <input
                        type="text"
                        maxLength="200"
                        name="careerContentArr"
                        class="form-control careerContent"
                        placeholder="주/조연, 배역, 배역 설명 등"
                        readOnly
                    />
                    <button
                        class="btn_input_delete"
                        type="button"
                        onclick="funRemoveElement(this, 'career')"
                    ></button>
                </div>
            </div>

            {/* <div id="temp_prizeM">
                <dl class="rows prize_item prizeM_item">
                    <input type="hidden" name="careerTypeArrM" value="P" />
                    <input type="hidden" name="actCodeArrM" value="0" />
                    <input type="hidden" name="broadNameArrM" value=" " />

                    <dt>수상연도</dt>
                    <dd>
                        <select name="careerYearArrM" class="custom-select">
                            <option value="0">연도선택</option>

                            <option value="2021">2021</option>

                            <option value="2020">2020</option>

                            <option value="2019">2019</option>

                            <option value="2018">2018</option>

                            <option value="2017">2017</option>

                            <option value="2016">2016</option>

                            <option value="2015">2015</option>

                            <option value="2014">2014</option>

                            <option value="2013">2013</option>

                            <option value="2012">2012</option>

                            <option value="2011">2011</option>

                            <option value="2010">2010</option>

                            <option value="2009">2009</option>

                            <option value="2008">2008</option>

                            <option value="2007">2007</option>

                            <option value="2006">2006</option>

                            <option value="2005">2005</option>

                            <option value="2004">2004</option>

                            <option value="2003">2003</option>

                            <option value="2002">2002</option>

                            <option value="2001">2001</option>

                            <option value="2000">2000 이전</option>
                        </select>
                    </dd>
                    <dt>수여기관</dt>
                    <dd>
                        <input
                            type="text"
                            maxLength="120"
                            class="form-control"
                            placeholder="수여기관 설명."
                            name="careerNameArrM"
                            value=""
                        />
                    </dd>
                    <dt>수상명</dt>
                    <dd>
                        <div class="input-group">
                            <input
                                type="text"
                                maxLength="200"
                                class="form-control"
                                placeholder="연기대상, 최우수상, 인기상 등"
                                name="careerContentArrM"
                                value=""
                            />
                            <button
                                class="btn_input_delete"
                                type="button"
                                onclick="funRemoveElement(this, 'prizeM')"
                            ></button>
                        </div>
                    </dd>
                </dl>
            </div>

            <div id="temp_career">
                <div class="input-group career_item">
                    <input type="hidden" name="careerTypeArr" value="C" />
                    <div class="input-group-prepend wp16">
                        <select
                            name="careerYearArr"
                            class="custom-select"
                            onchange="yearChange(this)"
                        >
                            <option value="0">연도선택</option>

                            <option value="2021">2021</option>

                            <option value="2020">2020</option>

                            <option value="2019">2019</option>

                            <option value="2018">2018</option>

                            <option value="2017">2017</option>

                            <option value="2016">2016</option>

                            <option value="2015">2015</option>

                            <option value="2014">2014</option>

                            <option value="2013">2013</option>

                            <option value="2012">2012</option>

                            <option value="2011">2011</option>

                            <option value="2010">2010</option>

                            <option value="2009">2009</option>

                            <option value="2008">2008</option>

                            <option value="2007">2007</option>

                            <option value="2006">2006</option>

                            <option value="2005">2005</option>

                            <option value="2004">2004</option>

                            <option value="2003">2003</option>

                            <option value="2002">2002</option>

                            <option value="2001">2001</option>

                            <option value="2000">2000 이전</option>
                        </select>
                    </div>

                    <div class="input-group-prepend wp16">
                        <select
                            name="actCodeArr"
                            class="custom-select act_code"
                            onchange="actChange(this)"
                            disabled
                        >
                            <option value="0">선택</option>

                            <option value="10050001">드라마</option>

                            <option value="10050002">영화</option>

                            <option value="10050003">웹드라마</option>

                            <option value="10050004">공연</option>
                        </select>
                    </div>

                    <div class="input-group-prepend wp32">
                        <input
                            type="text"
                            maxLength="20"
                            name="broadNameArr"
                            class="form-control  broadName"
                            placeholder="방송사 입력"
                        />
                        <input
                            type="text"
                            maxLength="120"
                            name="careerNameArr"
                            class="form-control careerName"
                            placeholder="작품명 입력"
                            readOnly
                        />
                    </div>
                    <input
                        type="text"
                        maxLength="200"
                        name="careerContentArr"
                        class="form-control careerContent"
                        placeholder="주/조연, 배역, 배역 설명 등"
                        readOnly
                    />
                    <button
                        class="btn_input_delete"
                        type="button"
                        onclick="funRemoveElement(this, 'career')"
                    ></button>
                </div>
            </div>

            <div id="temp_prize">
                <div class="input-group prize_item">
                    <input type="hidden" name="careerTypeArr" value="P" />
                    <input type="hidden" name="actCodeArr" value="0" />
                    <input type="hidden" name="broadNameArr" value=" " />

                    <div class="input-group-prepend wp16">
                        <select name="careerYearArr" class="custom-select">
                            <option value="0">연도선택</option>
                            <option value="2021">2021</option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000 이전</option>
                        </select>
                    </div>
                    <div class="input-group-prepend wp32">
                        <input
                            type="text"
                            maxLength="60"
                            class="form-control"
                            name="careerNameArr"
                            placeholder="수여기관 설명"
                        />
                        <input
                            type="text"
                            maxLength="200"
                            class="form-control"
                            placeholder="연기대상, 최우수상, 인기상 등"
                            name="careerContentArr"
                        />
                        <button
                            class="btn_input_delete"
                            type="button"
                            onclick="funRemoveElement(this, 'prize')"
                        ></button>
                    </div>
                </div>
            </div> */}
        </>
    );
};

export default ProfileCareer;
